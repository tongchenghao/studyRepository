package Thread.countDownLatchDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @description:线程计数器demo
 * @auth tongchenghao
 * @date 2020/2/6
 */
public class CountDownLatchDome {


    public static void main(String[] args) throws InterruptedException {

        int n = 20;

        // 计数器记录次数n
        CountDownLatch countDownLatch = new CountDownLatch(n);

        for (int i=0;i<n;i++){
            int k = i;
            new Thread(() -> {
                System.out.println("线程"+k+"开始");
                countDownLatch.countDown();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程"+k+"结束");
            }).start();
        }

        // 线程阻塞，直到执行n次countDownLatch.countDown();后，线程唤醒
        countDownLatch.await();
        System.out.println("主线程结束");
    }

}
