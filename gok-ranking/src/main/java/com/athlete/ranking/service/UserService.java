package com.athlete.ranking.service;

import com.athlete.ranking.domain.WxUser;
import com.athlete.ranking.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public WxUser selectByOpenId(String id){
        return userMapper.selectByOpenId(id);
    }

    public int getUserIdSeq(){
        return userMapper.nextVal();
    }

    public boolean insertUser(WxUser wxuser){
        return userMapper.insertUser(wxuser);
    }

    public boolean updateUser(WxUser wxuser){
        return userMapper.updateUser(wxuser);
    }

}
