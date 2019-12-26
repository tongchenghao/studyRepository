package abstr;

import bean.BaoMa;
import bean.Car;

/**
 * @description:宝马工厂
 * @auth tongchenghao
 * @date 2019/12/26
 */
public class BaoMaFacoty extends AbstractFactory{
    @Override
    public Car getCar() {
        return new BaoMa();
    }
}
