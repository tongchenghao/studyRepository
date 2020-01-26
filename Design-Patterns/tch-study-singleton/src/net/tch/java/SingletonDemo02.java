/**
 * @description:懒汉式
 * @auth tongchenghao
 * @date 2020/1/26
 */
public class SingletonDemo02 {
    //1.私有化构造方法
    private SingletonDemo02() {
    }
    //2.静态变量使实例只有一个，类初始化的时候，不立即加载该对象
    public static SingletonDemo02 instance;
    //3.提供一个获取方法，有使用synchronized，效率较低！
    public static synchronized SingletonDemo02 getInstance() {
        if(instance==null){
            instance = new SingletonDemo02();
        }
        return instance;
    }
}
class SingletonDemo02Test{
    public static void main(String[] args) {
        SingletonDemo02 instance1 = SingletonDemo02.getInstance();
        SingletonDemo02 instance2 = SingletonDemo02.getInstance();

        System.out.println(instance1==instance2);
    }
}