package Thread.conditionDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @description:juc线程唤醒demo，condition.signal()相当于Thread,notify()
 * @auth tongchenghao
 * @date 2020/2/3
 */
public class ThreadNotify extends Thread {

    private Lock lock;

    private Condition condition;

    public ThreadNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("开始执行 condition signal");
            condition.signal();// 唤醒等待的锁
            System.out.println("执行结束 condition signal");
        }finally {
            lock.unlock();
        }
    }
}
