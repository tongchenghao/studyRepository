package Thread.semaphoreDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @description:信号灯demo
 * @auth tongchenghao
 * @date 2020/2/6
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 限制同时只能有2个线程并发执行，限流
        int n = 2;
        Semaphore semaphore = new Semaphore(n);

        List<Thread> list = new ArrayList<>();

        for (int i=0;i<n*2;i++){
            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("线程" + finalI + "进入");
                    Thread.sleep(2000);
                    semaphore.release();
                    System.out.println("线程" + finalI + "释放令牌");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            list.add(thread);
        }

        list.forEach(thread -> {
            thread.start();
        });
    }
}
