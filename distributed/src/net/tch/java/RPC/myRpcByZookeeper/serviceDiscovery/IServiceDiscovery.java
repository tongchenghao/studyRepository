package net.tch.java.RPC.myRpcByZookeeper.serviceDiscovery;

/**
 * @description:用于客户端指定服务的服务
 * @auth tongchenghao
 * @date 2020/2/18
 */
public interface IServiceDiscovery {
    /**
     * 根据请求的服务地址，获取对应的调用地址
     * @param serviceName   请求的服务地址
     * @return
     */
    String discovery(String serviceName);
}
