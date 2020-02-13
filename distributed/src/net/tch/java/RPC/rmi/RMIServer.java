package net.tch.java.RPC.rmi;

import net.tch.java.RPC.IServiceDemo;
import net.tch.java.RPC.ServiceDemo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @description:RMI服务，通过RMI方式发布服务
 *      RMI是一个纯java的RPC框架
 * @auth tongchenghao
 * @date 2020/2/12
 */
public class RMIServer {

    public static void main(String[] args) {
        try {
            // 先实例化需要的服务
            IServiceDemo serviceDemo = new ServiceDemo();
            /**
             * 注册并发布服务
             */
            // 创建LocateRegistry,LocateRegistry就相当于一个注册中心
            LocateRegistry.createRegistry(1099);
            // 绑定服务地址及对应服务
            Naming.rebind("rmi://127.0.0.1/ServiceDemo",serviceDemo);
            System.out.println("服务已发布");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
