package net.tch.sso.controller;

/**
 * @description:
 * @auth tongchenghao
 * @date 2020/2/28
 */
public class BaseController {
    static ThreadLocal<String> uidThreadLocal = new ThreadLocal<>();

    public void setUid(String uid) {
        uidThreadLocal.set(uid);
    }

    public static String getUid() {
        return uidThreadLocal.get();
    }
}
