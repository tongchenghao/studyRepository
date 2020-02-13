package Thread.waitAndnotify;

/**
 * @description:Thread锁的阻塞和唤醒demo
 * @auth tongchenghao
 * @date 2020/2/3
 */
public class MainClass {

    public static void main(String[] args) {
        Object lock = new Object();

        //外部传入同一个lock，使得两个线程共用一把锁
        ThreadWait threadWait = new ThreadWait(lock);
        ThreadNotify threadNotify = new ThreadNotify(lock);

        threadWait.start();
        threadNotify.start();
    }
}
