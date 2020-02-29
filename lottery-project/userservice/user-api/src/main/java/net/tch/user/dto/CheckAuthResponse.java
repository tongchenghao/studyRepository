package net.tch.user.dto;

import net.tch.user.abs.AbstractResponse;

/**
 * @description:登录验证方法的返回值
 * @auth tongchenghao
 * @date 2020/2/28
 */
public class CheckAuthResponse extends AbstractResponse {
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "CheckAuthResponse{" +
                "uid='" + uid + '\'' +
                "} " + super.toString();
    }
}
