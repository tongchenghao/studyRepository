package Thread.threadStateDemo;

import java.util.concurrent.TimeUnit;

/**
 * @description: 线程状态demo,运行代码后进入编译文件目录，打开shell窗口，使用jdk提供的jps命令，再使用jstack {线程编号}来查看进程状态
 * @auth tongchenghao
 * @date 2020/2/2
 */
public class ThreadStateDemo {

    public static void main(String[] args) {

        new Thread(() -> {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"timeWaiting").start();

        new Thread(()->{
            while (true){
                synchronized (ThreadStateDemo.class){
                    try {
                        ThreadStateDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"waiting").start();


        new Thread(new BlockDemo(),"blockDemo-1").start();
        new Thread(new BlockDemo(),"blockDemo-2").start();


    }

    static class BlockDemo extends Thread{
        @Override
        public void run() {
            synchronized (BlockDemo.class){
                while (true){
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
