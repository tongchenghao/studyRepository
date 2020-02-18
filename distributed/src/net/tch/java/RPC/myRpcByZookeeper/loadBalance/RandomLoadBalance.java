package net.tch.java.RPC.myRpcByZookeeper.loadBalance;

import java.util.List;
import java.util.Random;

/**
 * @description:随机负载均衡
 * @auth tongchenghao
 * @date 2020/2/18
 */
public class RandomLoadBalance extends AbstractLoadBalance{
    @Override
    public String doSelect(List<String> repos) {
        int size = repos.size();
        Random random = new Random();
        // 获取随机数作为调用路径集合的下标
        int index = random.nextInt(size);
        return repos.get(index);
    }
}
