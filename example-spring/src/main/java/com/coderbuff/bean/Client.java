package com.coderbuff.bean;

/**
 * 客户端连接配置文件
 * Created by OKevin On 2019/8/28
 */
public class Client {

    private String url;

    private String user;

    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
