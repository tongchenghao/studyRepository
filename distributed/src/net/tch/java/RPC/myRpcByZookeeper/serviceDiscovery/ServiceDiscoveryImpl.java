package net.tch.java.RPC.myRpcByZookeeper.serviceDiscovery;

import net.tch.java.RPC.myRpcByZookeeper.ZKConfig;
import net.tch.java.RPC.myRpcByZookeeper.loadBalance.LoadBalance;
import net.tch.java.RPC.myRpcByZookeeper.loadBalance.RandomLoadBalance;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:用于客户端指定服务的服务
 * @auth tongchenghao
 * @date 2020/2/18
 */
public class ServiceDiscoveryImpl implements IServiceDiscovery {

    List<String> repos = new ArrayList<>();

    private String connect_str;

    private CuratorFramework curatorFramework;

    public ServiceDiscoveryImpl(String connect_str){
        curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(connect_str)
                .sessionTimeoutMs(4000)
                .retryPolicy(new ExponentialBackoffRetry(1000,10)).build();
        curatorFramework.start();
    }
    @Override
    public String discovery(String serviceName) {
        String servicePath = ZKConfig.ZK_REGISTER_PATH + "/" + serviceName;
        try {
            // 获取服务对应的所有调用地址
            repos = curatorFramework.getChildren().forPath(servicePath);
        } catch (Exception e) {
            throw new RuntimeException("获取服务失败："+serviceName,e);
        }
        // 动态发现节点变化
        registerWatcher(servicePath);
        // 负载均衡选择对应的调用地址
        LoadBalance loadBalance = new RandomLoadBalance();
        return loadBalance.selectHost(repos);
    }

    /**
     * 注册子节点监听，监听子节点的变化，子节点有变化时，重新获取数据
     * @param path
     */
    private void registerWatcher(String path){
        PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework,path,true);
        // 创建子节点监听事件
        PathChildrenCacheListener pathChildrenCacheListener = new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                repos = curatorFramework.getChildren().forPath(path);
            }
        };
        // 添加监听
        pathChildrenCache.getListenable().addListener(pathChildrenCacheListener);
        try {
            pathChildrenCache.start();
        } catch (Exception e) {
            throw new RuntimeException("注册PathChildCache Watcher失败"+e);
        }
    }
}
