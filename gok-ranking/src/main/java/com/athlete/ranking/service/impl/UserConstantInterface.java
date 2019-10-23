package com.athlete.ranking.service.impl;

public interface UserConstantInterface {
    // 请求的网址
    public static final String WX_LOGIN_URL = "https://api.weixin.qq.com/sns/jscode2session";
    // 你的appid
    public static final String WX_LOGIN_APPID = "wx3d3e33eb83f09d5b";
    // 你的密匙
    public static final String WX_LOGIN_SECRET = "f3fc666a86a1887735d7c8262eaf20f7";
    // 固定参数
    public static final String WX_LOGIN_GRANT_TYPE = "authorization_code";

}
