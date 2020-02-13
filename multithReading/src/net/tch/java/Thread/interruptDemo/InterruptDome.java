package Thread.interruptDemo;

import java.util.concurrent.TimeUnit;

/**
 * @description:interrupt()是优雅的关闭进程的方法，会阻止新的进程进入，等待已经进入的进程完成后关闭进程
 * @auth tongchenghao
 * @date 2020/2/2
 */
public class InterruptDome {

    public static int i;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(i);
        });
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }

}
