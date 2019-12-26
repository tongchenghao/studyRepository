package func;

import bean.BaoMa;
import bean.Car;

/**
 * @description:宝马工厂
 * @auth tongchenghao
 * @date 2019/12/26
 */
public class BaoMaFacoty implements CarFactory{
    @Override
    public Car getCar() {
        return new BaoMa();
    }
}
