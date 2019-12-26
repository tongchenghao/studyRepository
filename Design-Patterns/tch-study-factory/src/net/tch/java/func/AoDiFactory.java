package func;

import bean.AoDi;
import bean.Car;

/**
 * @description:奥迪工厂
 * @auth tongchenghao
 * @date 2019/12/26
 */
public class AoDiFactory implements CarFactory{
    @Override
    public Car getCar() {
        return new AoDi();
    }
}
