package com.athlete.ranking.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.athlete.ranking.domain.User;
import com.athlete.ranking.domain.WxUser;
import com.athlete.ranking.service.UserService;
import com.athlete.ranking.service.impl.UserConstantInterface;
import com.athlete.ranking.utils.HttpClientUtil;
import com.athlete.ranking.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.athlete.ranking.utils.JsonResult.ERROR;
import static com.athlete.ranking.utils.JsonResult.SUCCESS;

@RestController
@RequestMapping("/api")
public class UserApi {

    @Autowired
    private UserService userService;


    @PostMapping ("/login")
    public JsonResult user_login(
            @RequestParam("code") String code,
            @RequestParam("userinfo") String userinfo

    ){
        // 配置请求参数
        Map<String, String> param = new HashMap<>();
        param.put("appid", UserConstantInterface.WX_LOGIN_APPID);
        param.put("secret", UserConstantInterface.WX_LOGIN_SECRET);
        param.put("js_code", code);
        param.put("grant_type", UserConstantInterface.WX_LOGIN_GRANT_TYPE);
        // 发送请求
        String wxResult = HttpClientUtil.doGet(UserConstantInterface.WX_LOGIN_URL, param);
        JSONObject jsonObject = JSONObject.parseObject(wxResult);
        // 获取参数返回的
        String session_key = jsonObject.get("session_key").toString();
        String open_id = jsonObject.get("openid").toString();
        JSONObject wx_userInfo = JSONObject.parseObject(userinfo);
        // 根据返回的user实体类，判断用户是否是新用户，不是的话，更新最新登录时间，是的话，将用户信息存到数据库
        WxUser user = userService.selectByOpenId(open_id);
        if(user != null){
            user.setLogintime(new Date());
            user.setNickname(wx_userInfo.get("nickName").toString());
            user.setAvatarurl(wx_userInfo.get("avatarUrl").toString());
            userService.updateUser(user);
        }else{

            int id = userService.getUserIdSeq();
            WxUser insert_user = new WxUser();
            insert_user.setId(id);
            insert_user.setAvatarurl(wx_userInfo.get("avatarUrl").toString());
            insert_user.setNickname(wx_userInfo.get("nickName").toString());
            insert_user.setGender((Integer) wx_userInfo.get("gender"));
            insert_user.setCtime(new Date());
            insert_user.setCity(wx_userInfo.get("city").toString());
            insert_user.setProvince(wx_userInfo.get("province").toString());
            insert_user.setOpenid(open_id);
            insert_user.setLanguage(wx_userInfo.get("language").toString());
            insert_user.setCountry(wx_userInfo.get("country").toString());
            System.out.println("insert_user:"+insert_user.toString());
            // 添加到数据库
            Boolean flag = userService.insertUser(insert_user);

            if(!flag){
                return new JsonResult(ERROR);
            }
        }
        // 封装返回小程序
        Map<String, String> result = new HashMap<>();
        result.put("session_key", session_key);
        result.put("open_id", open_id);
        return new JsonResult(SUCCESS, result);

    }

}
