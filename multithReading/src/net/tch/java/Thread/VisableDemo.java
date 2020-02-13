package Thread;

import java.util.concurrent.TimeUnit;

/**
 * @description:可见性问题
 * @auth tongchenghao
 * @date 2020/2/2
 */
public class VisableDemo {

    /**
     * 标志位需要加上 volatile 保证可见性，不然在主线程main方法中改变的值无法被子线程获取到，涉及到内存隔离的问题
     */
//    public static boolean stop = false;
    public volatile static boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            double i = 0;
           while (!stop){
               i++;
           }
            System.out.println(i);
        }).start();
        TimeUnit.SECONDS.sleep(1);
        stop = true;
    }

}
