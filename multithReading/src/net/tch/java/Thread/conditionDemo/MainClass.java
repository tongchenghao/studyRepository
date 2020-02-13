package Thread.conditionDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:condition的使用，juc的lock锁中需要中断或者唤醒需要使用condition
 * @auth tongchenghao
 * @date 2020/2/3
 */
public class MainClass {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        //外部传入同一个lock，使得两个线程共用一把锁
        ThreadWait threadWait = new ThreadWait(lock,condition);
        ThreadNotify threadNotify = new ThreadNotify(lock,condition);

        threadWait.start();
        threadNotify.start();
    }
}
