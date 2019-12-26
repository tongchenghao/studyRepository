package simpleFactory;

import bean.Car;

/**
 * @description:简单工厂测试类
 * @auth tongchenghao
 * @date 2019/12/26
 */
public class TestClass {
    public static void main(String[] args) {
        SimpleFactory  simpleFactory = new SimpleFactory();
        Car car = simpleFactory.getCar("宝马");
        car.descriptSelf();
    }
}
