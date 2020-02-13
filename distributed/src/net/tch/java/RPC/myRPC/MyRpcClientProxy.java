package net.tch.java.RPC.myRPC;

import java.lang.reflect.Proxy;

/**
 * @description:代理类获取工具
 * @auth tongchenghao
 * @date 2020/2/13
 */
public class MyRpcClientProxy {

    /**
     * 获取代理类
     * @param interfaceCls
     * @param host
     * @param port
     * @param <T>
     * @return
     */
    public static  <T> T clientProxy(Class<T> interfaceCls,String host,int port){
        // 获取代理类，代理类处理方法在MyRpcClientInvocationHandler中
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),new Class[]{interfaceCls},new MyRpcClientInvocationHandler(host,port));
    }

}
