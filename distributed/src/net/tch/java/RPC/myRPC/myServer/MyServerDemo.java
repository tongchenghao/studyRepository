package net.tch.java.RPC.myRPC.myServer;

import net.tch.java.RPC.IServiceDemo;
import net.tch.java.RPC.ServiceDemo;
import net.tch.java.RPC.myRPC.MyRpcServer;

import java.rmi.RemoteException;

/**
 * @description:自己根据rmi原理实现的简易rpc框架的测试服务端demo
 * @auth tongchenghao
 * @date 2020/2/13
 */
public class MyServerDemo {
    public static void main(String[] args) {
        try {
            IServiceDemo serviceDemo = new ServiceDemo();
            MyRpcServer myRpcServer = new MyRpcServer();
            // 发布服务
            myRpcServer.publisher(serviceDemo,1255);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
