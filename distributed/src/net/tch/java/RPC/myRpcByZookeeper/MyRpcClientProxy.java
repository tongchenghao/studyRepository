package net.tch.java.RPC.myRpcByZookeeper;

import net.tch.java.RPC.myRpcByZookeeper.serviceDiscovery.IServiceDiscovery;

import java.lang.reflect.Proxy;

/**
 * @description:代理类获取工具
 * @auth tongchenghao
 * @date 2020/2/13
 */
public class MyRpcClientProxy {

    IServiceDiscovery serviceDiscovery;

    public MyRpcClientProxy(IServiceDiscovery serviceDiscovery) {
        this.serviceDiscovery = serviceDiscovery;
    }

    /**
     * 获取代理类
     * @param interfaceCls
     * @param serviceDiscovery
     * @param <T>
     * @return
     */
    public static  <T> T clientProxy(Class<T> interfaceCls,IServiceDiscovery serviceDiscovery,String version){
        // 获取代理类，代理类处理方法在MyRpcClientInvocationHandler中
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(),new Class[]{interfaceCls},new MyRpcClientInvocationHandler(serviceDiscovery,version));
    }

}
