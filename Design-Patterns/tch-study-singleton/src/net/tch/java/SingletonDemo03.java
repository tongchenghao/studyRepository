/**
 * @description:DCL懒汉式
 * @auth tongchenghao
 * @date 2020/1/26
 */
public class SingletonDemo03 {
    //1.私有化构造方法
    private SingletonDemo03() {
    }
    //2.静态变量使实例只有一个，类初始化的时候，不立即加载该对象
    public volatile static SingletonDemo03 instance;
    //3.提供一个获取方法，有使用synchronized，效率较低！
    public static synchronized SingletonDemo03 getInstance() {
        if(instance==null){
            synchronized (SingletonDemo03.class){
                if(instance==null){
                    instance = new SingletonDemo03();
                }
            }
        }
        return instance;
    }
}

class SingletonDemo03Test{
    public static void main(String[] args) {
        SingletonDemo03 instance1 = SingletonDemo03.getInstance();
        SingletonDemo03 instance2 = SingletonDemo03.getInstance();

        System.out.println(instance1==instance2);
    }
}