package abstr;

import bean.Car;
import simpleFactory.SimpleFactory;

/**
 * @description:抽象工厂测试类
 * 优点：
 *  1.用户使用不用关心需要用哪个工厂实现只要简单调用DefaultFactory来生产对象即可。
 *  2。不同对象的生产使用不同工厂来实现，选择工厂的方法由抽象类提供，起到了生产对象的逻辑分离的作用，有利于代码的维护
 * 思考：为什么使用抽象类而不是接口？
 *  如果使用接口，那么在每一个实现中都要实现getCar(String name)的方法，这显然不符合逻辑，
 *  使用抽象类就是因为他能够自带getCar(String name)的实现逻辑，这个是每个继承他的类都需要的。
 * @auth tongchenghao
 * @date 2019/12/26
 */
public class TestClass {
    public static void main(String[] args) {
        DefaultFactory defaultFactory = new DefaultFactory();
        defaultFactory.getCar();
        Car baoma = defaultFactory.getCar("宝马");
        baoma.descriptSelf();
        Car aodi = defaultFactory.getCar("奥迪");
        aodi.descriptSelf();
        Car benchi = defaultFactory.getCar("奔驰");
        benchi.descriptSelf();
    }
}
