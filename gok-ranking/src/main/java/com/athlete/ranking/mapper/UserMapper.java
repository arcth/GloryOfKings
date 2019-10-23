package com.athlete.ranking.mapper;


import com.athlete.ranking.domain.User;
import com.athlete.ranking.domain.WxUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    WxUser selectByOpenId(String id);
    int nextVal();
    boolean insertUser(WxUser wxuser);
    boolean updateUser(WxUser wxuser);

}