package net.tch.java.zookeeper.distributedLock;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @description:基于zookeeper实现分布式锁的测试类
 * @auth tongchenghao
 * @date 2020/2/18
 */
public class TestMain {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i=0;i<4;i++){
            new Thread(()->{
                try {
                    countDownLatch.await();
                    DistributeLock distributeLock = new DistributeLock();
                    distributeLock.lock();
                    Thread.sleep(2000);
                    distributeLock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"Thread-"+i).start();
            countDownLatch.countDown();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
