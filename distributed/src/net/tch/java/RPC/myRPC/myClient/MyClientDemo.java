package net.tch.java.RPC.myRPC.myClient;

import net.tch.java.RPC.IServiceDemo;
import net.tch.java.RPC.myRPC.MyRpcClientProxy;

import java.rmi.RemoteException;

/**
 * @description:自己根据rmi原理实现的简易rpc框架的测试客户端demo
 * @auth tongchenghao
 * @date 2020/2/13
 */
public class MyClientDemo {
    public static void main(String[] args) {
        IServiceDemo serviceDemo = MyRpcClientProxy.clientProxy(IServiceDemo.class,"127.0.0.1",1255);
        try {
            String result = serviceDemo.sayHello("童诚浩");
            System.out.println(result);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
