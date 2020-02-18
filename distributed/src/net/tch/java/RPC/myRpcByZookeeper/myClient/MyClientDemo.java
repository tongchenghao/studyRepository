package net.tch.java.RPC.myRpcByZookeeper.myClient;

import net.tch.java.RPC.IServiceDemo;
import net.tch.java.RPC.myRpcByZookeeper.MyRpcClientProxy;
import net.tch.java.RPC.myRpcByZookeeper.ZKConfig;
import net.tch.java.RPC.myRpcByZookeeper.serviceDiscovery.IServiceDiscovery;
import net.tch.java.RPC.myRpcByZookeeper.serviceDiscovery.ServiceDiscoveryImpl;

import java.rmi.RemoteException;

/**
 * @description:自己根据rmi原理并使用zookeeper作为注册中心实现的简易rpc框架的测试客户端demo
 * @auth tongchenghao
 * @date 2020/2/13
 */
public class MyClientDemo {
    public static void main(String[] args) {
        // 服务查找器连接到对应的注册中心
        IServiceDiscovery serviceDiscovery = new ServiceDiscoveryImpl(ZKConfig.CONNECTION_STR);
        IServiceDemo serviceDemo = MyRpcClientProxy.clientProxy(IServiceDemo.class,serviceDiscovery,"2.0");
        try {
            String result = serviceDemo.sayHello("童诚浩");
            System.out.println(result);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
