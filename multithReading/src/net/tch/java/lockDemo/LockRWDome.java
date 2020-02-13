package lockDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:重录读写锁
 *      其他的锁都是排他锁，一个线程获得锁，其他线程就无法获得锁；
 *      而重录读写锁是一个共享锁，允许多个线程同时获得锁，在读多写少的情况下适用
 *      读写锁有一对锁：读锁  写锁
 *      读锁  读锁  之间是共享
 *      读锁  写锁  之间是不共享
 *      写锁  写锁  之间是不共享
 * @auth tongchenghao
 * @date 2020/2/4
 */
public class LockRWDome extends Thread{

    static Map<String,String> cachMap = new HashMap<>();

    // 重用读写锁
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 获得读锁
    static Lock readLock =  readWriteLock.readLock();
    // 获得写锁
    static Lock writeLock =  readWriteLock.writeLock();

    public static String getCachMapValue(String key) {
        // 读锁可以由多个线程获得，但当有线程获得读锁时，写锁阻塞
        readLock.lock();
        try {
            return cachMap.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public static void setCachMapValue(String key,String value) {
        // 写锁也可以由多个线程获得，但当有线程获得写锁时，读锁阻塞
        writeLock.lock();
        try {
            LockRWDome.cachMap.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }
}
