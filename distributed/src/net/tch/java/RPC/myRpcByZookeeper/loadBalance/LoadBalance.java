package net.tch.java.RPC.myRpcByZookeeper.loadBalance;

import java.util.List;

/**
 * @description:负载均衡接口
 * @auth tongchenghao
 * @date 2020/2/18
 */
public interface LoadBalance {

    String selectHost(List<String> repos);

}
