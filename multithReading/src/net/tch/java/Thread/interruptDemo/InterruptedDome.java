package Thread.interruptDemo;

import java.util.concurrent.TimeUnit;

/**
 * @description:Interrupted()线程复位方法，复位后值为false
 * @auth tongchenghao
 * @date 2020/2/2
 */
public class InterruptedDome {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true){
                boolean interrupted = Thread.currentThread().isInterrupted();
                if (interrupted) {
                    System.out.println("before:" + interrupted);
                    Thread.interrupted();//线程复位
                    interrupted = Thread.currentThread().isInterrupted();
                    System.out.println("after:" + interrupted);
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
