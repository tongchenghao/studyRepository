package abstr;

import bean.BenChi;
import bean.Car;

/**
 * @description:奔驰工厂
 * @auth tongchenghao
 * @date 2019/12/26
 */
public class BenChiFactory extends AbstractFactory{
    @Override
    public Car getCar() {
        return new BenChi();
    }
}
