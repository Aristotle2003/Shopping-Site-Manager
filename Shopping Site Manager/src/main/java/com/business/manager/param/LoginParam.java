package com.business.manager.param;

/**
 * 登陆接口参数集合
 */
public class LoginParam {
    private String username;//用户名
    private String password;//密码
    private String captcha;//验证码
    private String randomStr;//随机字符串

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getRandomStr() {
        return randomStr;
    }

    public void setRandomStr(String randomStr) {
        this.randomStr = randomStr;
    }
}
