package net.tch.user.dto;

import java.io.Serializable;

/**
 * @description:登录验证方法的请求值
 * @auth tongchenghao
 * @date 2020/2/28
 */
public class CheckAuthRequest implements Serializable {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CheckAuthRequest{" +
                "token='" + token + '\'' +
                '}';
    }
}
