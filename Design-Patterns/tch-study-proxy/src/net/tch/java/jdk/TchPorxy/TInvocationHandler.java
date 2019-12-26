package jdk.TchPorxy;

import java.lang.reflect.Method;

/**
 * @description:自己实现代理模式
 * @auth tongchenghao
 * @date 2019/12/24
 */
public interface TInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
