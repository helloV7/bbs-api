package com.jyt.bbs.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

public class CustomizedToken extends UsernamePasswordToken {
    //登录类型，判断是普通用户登录，还是管理员登录
    private LoginType loginType;

    private LoginChannel loginChannel;

    public CustomizedToken(final String username, final String password,LoginType loginType) {
        this(username,password,loginType,null);
    }
    public CustomizedToken(final String username, final String password,LoginType loginType,LoginChannel loginChannel) {
        super(username,password);
        this.loginType = loginType;
        this.loginChannel = loginChannel;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public LoginChannel getLoginChannel() {
        return loginChannel;
    }

    public void setLoginChannel(LoginChannel loginChannel) {
        this.loginChannel = loginChannel;
    }
}
