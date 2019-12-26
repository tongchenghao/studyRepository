package abstr;

import bean.Car;

/**
 * @description:
 * @auth tongchenghao
 * @date 2019/12/26
 */
public class DefaultFactory extends AbstractFactory{
    @Override
    protected Car getCar() {
        return new BaoMaFacoty().getCar();
    }
}
