package net.tch.user.dto;

import java.io.Serializable;

/**
 * @description:用户登录请求信息
 * @auth tongchenghao
 * @date 2020/2/25
 */
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -5560505969803402647L;
    private String username;
    private String password;

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

    @Override
    public String toString() {
        return "UserLoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
