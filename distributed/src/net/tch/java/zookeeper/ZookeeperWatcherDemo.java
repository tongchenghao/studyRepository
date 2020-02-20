package net.tch.java.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @description:了解zookeeper的watch机制
 * @auth tongchenghao
 * @date 2020/2/19
 */
public class ZookeeperWatcherDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        try {
            // 连接zookeeper服务器
            ZooKeeper zooKeeper = new ZooKeeper("192.168.137.5:2181", 4000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println(watchedEvent.getType() + "->" + watchedEvent.getPath());
                    // 当连接状态为Event.KeeperState.SyncConnected时表示连接真正建立
                    if (watchedEvent.getState().equals(Event.KeeperState.SyncConnected)) {
                        // 此时停止阻塞线程
                        countDownLatch.countDown();
                    }
                }
            });

            System.out.println(zooKeeper.getState());// 此时连接状态为CONNECTING
            System.out.println("连接开始时间:" + new Date().getTime());// 连接开始时间
            // 只有当连接状态为CONNECTED时zookeeper才能正常使用,所以一下操作应该等到连接真正建立后进行
            // 此时我们可以阻塞线程，等待监听确定连接已经真正建立再运行
            countDownLatch.await();
            System.out.println("连接结束时间:" + new Date().getTime());// 连接结束时间
            System.out.println(zooKeeper.getState());// 此时连接状态为CONNECTED

            // 创建一个节点
            zooKeeper.create("/test", "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            // 有且仅有exists  getdata  getchildren三个方法可以绑定事件
            // 通过exists绑定事件
            Stat stat = zooKeeper.exists("/test", new Watcher() {
                /**
                 * 监听事件只会被调用一次
                 * @param event
                 */
                @Override
                public void process(WatchedEvent event) {
                    System.out.println(event.getType() + "->" + event.getPath());
                    try {
                        // watch为true则会跳转到全局的默认监听中
                        zooKeeper.exists(event.getPath(),true);
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            // 事务操作会触发watch事件，如：create,delete,setData
            stat = zooKeeper.setData("/test","2".getBytes(),stat.getVersion());
            Thread.sleep(4000);
            zooKeeper.delete("/test",stat.getVersion());
            zooKeeper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
