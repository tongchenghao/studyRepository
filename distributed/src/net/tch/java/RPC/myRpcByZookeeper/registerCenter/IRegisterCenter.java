package net.tch.java.RPC.myRpcByZookeeper.registerCenter;

/**
 * @description:注册中心接口
 * @auth tongchenghao
 * @date 2020/2/18
 */
public interface IRegisterCenter {

    /**
     * 注册服务名称和服务地址
     * @param serviceName
     * @param serviceAddress
     */
    void register(String serviceName,String serviceAddress);
}
