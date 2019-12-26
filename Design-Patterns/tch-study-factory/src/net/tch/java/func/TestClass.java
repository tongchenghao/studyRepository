package func;

import bean.Car;

/**
 * @description：工厂方法测试类
 * 优点：分离了业务逻辑，代码更便于维护
 * 缺点：用户使用时却需要区分使用哪个工厂来获得需要的对象，不符合逻辑
 * 因此需要引入抽象工厂，既分离业务逻辑，又不用用户区分使用哪个工厂
 * @auth tongchenghao
 * @date 2019/12/26
 */
public class TestClass {
    public static void main(String[] args) {
        AoDiFactory aoDiFactory = new AoDiFactory();
        Car aodi = aoDiFactory.getCar();
        aodi.descriptSelf();
        BaoMaFacoty baoMaFacoty = new BaoMaFacoty();
        Car baoma = baoMaFacoty.getCar();
        baoma.descriptSelf();
        BenChiFactory benChiFactory = new BenChiFactory();
        Car benchi = benChiFactory.getCar();
        benchi.descriptSelf();
    }
}
