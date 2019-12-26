package abstr;

import bean.AoDi;
import bean.BaoMa;
import bean.BenChi;
import bean.Car;

/**
 * @description:抽象工厂类
 * @auth tongchenghao
 * @date 2019/12/26
 */
public abstract class AbstractFactory {
    protected abstract Car getCar();

    public Car getCar(String name){
        if("奔驰".equals(name)){
            return new BenChiFactory().getCar();
        }else if("宝马".equals(name)){
            return new BaoMaFacoty().getCar();
        }else if("奥迪".equals(name)){
            return new AoDiFactory().getCar();
        }else{
            System.out.println("当前无法生产"+name+"车");
            return null;
        }
    }
}
