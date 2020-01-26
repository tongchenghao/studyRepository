/**
 * @description:饿汉式单例模式
 * @auth tongchenghao
 * @date 2020/1/26
 */
public class SingletonDemo01 {
    //1.私有化构造方法
    private SingletonDemo01() {
    }
    //2.静态变量使实例只有一个，类初始化的时候，立即加载该对象
    public static SingletonDemo01 instance = new SingletonDemo01();
    //3.提供一个获取方法，没有使用synchronized，效率高！
    public static synchronized SingletonDemo01 getInstance() {
        return instance;
    }

    //缺点：类初始化的时候就立即加载对象，导致无论对象是否被使用都会被加载，如果该对象占用空间很大，又没有被使用就会造成极大的资源浪费。
    public static  byte[] data1 = new byte[1024];
    public static  byte[] data2 = new byte[1024];
    public static  byte[] data3 = new byte[1024];
    public static  byte[] data4 = new byte[1024];
    public static  byte[] data5 = new byte[1024];

    public static byte[] getData1() {
        return data1;
    }

    public static byte[] getData2() {
        return data2;
    }

    public static byte[] getData3() {
        return data3;
    }

    public static byte[] getData4() {
        return data4;
    }

    public static byte[] getData5() {
        return data5;
    }
}
class SingletonDemo01Test{
    public static void main(String[] args) {
        SingletonDemo01 instance1 = SingletonDemo01.getInstance();
        SingletonDemo01 instance2 = SingletonDemo01.getInstance();

        System.out.println(instance1==instance2);
    }
}