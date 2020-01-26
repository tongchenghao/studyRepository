import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @description:静态内部类实现
 * @auth tongchenghao
 * @date 2020/1/26
 */
public class SingletonDemo04 {
    //1.私有化构造方法
    private SingletonDemo04() {
    }

    //2.声明一个静态内部类，在内部类里实例SingletonDemo04
    private static class innerClass{
        //保证了内存中只有一个实例对象
        public static final SingletonDemo04 instance = new SingletonDemo04();
    }

    //3.提供一个获取方法，再内部类被调用时才会被加载，类加载线程安全
    public static SingletonDemo04 getInstance() {
        return innerClass.instance;
    }
}

class SingletonDemo04Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SingletonDemo04 instance1 = SingletonDemo04.getInstance();
        SingletonDemo04 instance2 = SingletonDemo04.getInstance();

        System.out.println(instance1==instance2);

        /**
         * 反射机制可以破坏
         */
        //获取构造方法
        Constructor<SingletonDemo04> declaredConstructor = SingletonDemo04.class.getDeclaredConstructor(null);
        //关闭检测
        declaredConstructor.setAccessible(true);
        //实例化对象
        SingletonDemo04 instance3 = declaredConstructor.newInstance();

        System.out.println(instance1==instance3);
        System.out.println(instance1.hashCode());
        System.out.println(instance3.hashCode());

    }
}