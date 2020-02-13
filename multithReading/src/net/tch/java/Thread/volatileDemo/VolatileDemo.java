package Thread.volatileDemo;

/**
 * @description:可见性demo
 * @auth tongchenghao
 * @date 2020/2/2
 */
public class VolatileDemo {

    /**
     * 以下代码输出结果为4中：x=0;y=1  x=1;y=0  x=1;y=1  x=0;y=0
     * 分别看两个线程中的代码，(a = 1 和 y = b)语义上没有关联，（b = 1 和 x = a）也没有关联。
     * 这涉及到代码在编译过程中出现的指令重排序的问题，指令重排序不会影响语义，但却会实实在在的修改代码编译后的{！！！指令顺序}
     * 一、x=0;y=1的运行过程指令为
     *  1.a = 1;
     *  2.x = b;
     *  3.b = 1;
     *  4.y = a;
     * 二、x=1;y=0的运行过程指令为
     *  1.b = 1;
     *  2.x = b;
     *  3.y = a;
     *  4.a = 1;
     * 三、x=1;y=1的运行过程指令为
     *  1.b = 1;
     *  2.a = 1;
     *  3.y = a;
     *  4.x = b;
     * 四、x=0;y=0的运行过程指令为
     *  1.y = a;
     *  2.x = b;
     *  3.b = 1;
     *  4.a = 1;
     */
//    private static int x=0,y=0;
//    private static int a=0,b=0;

    private volatile static int x=0,y=0;
    private volatile static int a=0,b=0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("thread1开始睡眠");
                Thread.sleep(2000);
                System.out.println("thread1结束睡眠");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = 1;
            x = b;
        });
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("thread2开始睡眠");
                Thread.sleep(4000);
                System.out.println("thread2结束睡眠");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            y = a;
        });

        thread1.start();
        thread2.start();
        System.out.println("线程开始");
        try {
            thread1.join();//join 阻塞主线程等待thread1线程结果
            System.out.println("thread1线程结束");
            thread2.join();//join 阻塞主线程等待thread2线程结果
            System.out.println("thread2线程结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("x="+x+";y="+y);

    }

}
