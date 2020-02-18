package net.tch.java.RPC.myRpcByZookeeper.myServer;

import net.tch.java.RPC.IServiceDemo;
import net.tch.java.RPC.ServiceDemo;
import net.tch.java.RPC.myRpcByZookeeper.MyRpcServer;
import net.tch.java.RPC.myRpcByZookeeper.ServiceDemo2;
import net.tch.java.RPC.myRpcByZookeeper.registerCenter.IRegisterCenter;
import net.tch.java.RPC.myRpcByZookeeper.registerCenter.RegisterCenterImpl;

import java.rmi.RemoteException;

/**
 * @description:自己根据rmi原理并使用zookeeper作为注册中心实现的简易rpc框架的测试服务端demo
 * @auth tongchenghao
 * @date 2020/2/13
 */
public class MyServerDemo {
    public static void main(String[] args) {
        try {
            IServiceDemo serviceDemo = new ServiceDemo();
            IServiceDemo serviceDemo2 = new ServiceDemo2();
            IRegisterCenter registerCenter = new RegisterCenterImpl();

            MyRpcServer myRpcServer = new MyRpcServer(registerCenter,"127.0.0.1:6431");
            myRpcServer.bind(serviceDemo,serviceDemo2);
            // 发布服务
            myRpcServer.publisher();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
