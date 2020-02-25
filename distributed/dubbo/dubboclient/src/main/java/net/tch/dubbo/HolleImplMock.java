package net.tch.dubbo;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: holleImpl服务的降级服务
 *      降级服务一般写在客户端，在服务请求超时时会调用降级服务给以用户一个友好的提示
 * @auth tongchenghao
 * @date 2020/2/21
 */
public class HolleImplMock implements Holle{

    @Override
    public String sayHolle(String msg) {
        return "系统繁忙请稍后再试";
    }
}
