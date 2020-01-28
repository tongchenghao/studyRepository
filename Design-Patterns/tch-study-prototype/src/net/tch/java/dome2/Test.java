package dome2;

import java.util.Date;

/**
 * @description:
 * @auth tongchenghao
 * @date 2020/1/28
 */
public class Test {
    public static void main(String[] args) {
        Tribe tribe = new Tribe("firstTribe",1000,500000,new Date());
        Monkey monKey = new Monkey(150,100,Variety.China,tribe);
        try {
            Monkey copy = (Monkey)monKey.clone();
            System.out.println(copy == monKey);
            //枚举类型可以看做基本类型
            System.out.println(copy.variety == monKey.variety);
            copy.setVariety(Variety.America);
            System.out.println(copy.variety);
            System.out.println(monKey.variety);

            //部落对象也被复制了
            System.out.println(copy.tribe == monKey.tribe);
            System.out.println(copy.tribe.createDate == monKey.tribe.createDate);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
