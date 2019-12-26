package simpleFactory;

import bean.AoDi;
import bean.BaoMa;
import bean.BenChi;
import bean.Car;

/**
 * @description:简单工厂
 * 优点：用户只需要使用工厂就能得到自己想要的对象，而不需要关系对象的生产过程
 * 缺点：对象生产过程复制切繁多时，全部写在一个方法里面显得紊乱且不便于维护
 * @auth tongchenghao
 * @date 2019/12/26
 */
public class SimpleFactory {

    public Car getCar(String name){
        if("奔驰".equals(name)){
            return new BenChi();
        }else if("宝马".equals(name)){
            return new BaoMa();
        }else if("奥迪".equals(name)){
            return new AoDi();
        }else{
            System.out.println("当前无法生产"+name+"车");
            return null;
        }
    }
}
