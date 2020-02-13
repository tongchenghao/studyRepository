package Thread.conditionDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @description:juc线程等待demo，condition.await()相当于Thread,wait()
 * @auth tongchenghao
 * @date 2020/2/3
 */
public class ThreadWait extends Thread {

    private Lock lock;

    private Condition condition;

    public ThreadWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            lock.lock();
            System.out.println("开始执行 condition await");
            condition.await();// 唤醒等待的锁
            System.out.println("执行结束 condition await");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
