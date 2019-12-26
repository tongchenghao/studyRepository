package abstr;

import bean.AoDi;
import bean.Car;

/**
 * @description:奥迪工厂
 * @auth tongchenghao
 * @date 2019/12/26
 */
public class AoDiFactory extends AbstractFactory{
    @Override
    public Car getCar() {
        return new AoDi();
    }
}
