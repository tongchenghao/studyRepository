package net.tch.user.dto;

import net.tch.user.abs.AbstractResponse;

/**
 * @description:用户登录返回信息
 * @auth tongchenghao
 * @date 2020/2/25
 */
public class UserLoginResponse extends AbstractResponse {
    private static final long serialVersionUID = 2153256878039611750L;

    private Integer uid;
    private String avatar;// 头像
    private String mobile;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserLoginResponse{" +
                "uid=" + uid +
                ", avatar='" + avatar + '\'' +
                ", mobile='" + mobile + '\'' +
                ", token='" + token + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
