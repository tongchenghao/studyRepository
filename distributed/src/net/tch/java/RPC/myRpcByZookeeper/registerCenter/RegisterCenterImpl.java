package net.tch.java.RPC.myRpcByZookeeper.registerCenter;

import net.tch.java.RPC.myRpcByZookeeper.ZKConfig;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @description:注册中心实现
 * @auth tongchenghao
 * @date 2020/2/18
 */
public class RegisterCenterImpl implements IRegisterCenter {
    private CuratorFramework curatorFramework;

    {
        curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(ZKConfig.CONNECTION_STR)
                .sessionTimeoutMs(4000)
                .retryPolicy(new ExponentialBackoffRetry(1000,10)).build();
        curatorFramework.start();
    }

    @Override
    public void register(String serviceName, String serviceAddress) {
        // 注册服务
        String servicePath = ZKConfig.ZK_REGISTER_PATH  + "/" + serviceName;

        try {
            // 判断路径为servicePath的节点是否存在，如果不存在则创建对应的持久化节点
            if(curatorFramework.checkExists().forPath(servicePath)==null){
                curatorFramework.create().creatingParentsIfNeeded()
                        .withMode(CreateMode.PERSISTENT).forPath(servicePath,"0".getBytes());
            }
            // 创建服务地址为临时节点
            String addressPath = servicePath+"/"+serviceAddress;
            String rsNode = curatorFramework.create().withMode(CreateMode.EPHEMERAL)
                    .forPath(addressPath, "0".getBytes());
            System.out.println("服务注册成功：" + rsNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
