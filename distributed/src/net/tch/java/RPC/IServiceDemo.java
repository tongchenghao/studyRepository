package net.tch.java.RPC;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @description:服务Demo接口，该服务将被发布，给与其他进程调用，来测试各个rpc框架的功能
 *      1.使用RMI框架
 *          使用RMI框架服务接口必须继承Remote接口
 * @auth tongchenghao
 * @date 2020/2/12
 */
public interface IServiceDemo extends Remote {

    String sayHello(String msg) throws RemoteException;
}
