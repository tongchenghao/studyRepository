package net.tch.java.RPC.myRpcByZookeeper.loadBalance;

import java.util.List;

/**
 * @description:负载均衡抽象类
 * @auth tongchenghao
 * @date 2020/2/18
 */
public abstract class AbstractLoadBalance implements LoadBalance{

    @Override
    public String selectHost(List<String> repos) {
        if(repos==null||repos.size()<=0){
            return null;
        }
        if(repos.size()==1){
            return repos.get(0);
        }
        return doSelect(repos);
    }

    public abstract String doSelect(List<String> repos);
}
