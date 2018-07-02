package com.fndsoft.demonstration.config;

/**
 * @创建人 bob
 * @创建时间 2018/6/5
 * @描述：登录或注册结果
 */
public class LoginResult {

    private String name;

    private String msg;

    private boolean result;

    private String token;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
