package Thread.waitAndnotify;

/**
 * @description:Thread锁的唤醒demo
 * @auth tongchenghao
 * @date 2020/2/3
 */
public class ThreadNotify extends Thread {

    private Object lock;

    public ThreadNotify(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("开始执行 thread notify");
            lock.notify();// 唤醒等待的锁
            System.out.println("执行结束 thread notify");
        }
    }
}
