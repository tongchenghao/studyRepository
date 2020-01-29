/**
 * @description:饮料机
 * @auth tongchenghao
 * @date 2020/1/28
 */
public abstract class Beverage {

    //模板模式的模板不应该被其他方法修改，所以加上final关键字
    public final void create(){
        //1.烧开水
        boilWater();
        //2.放入原料
        pullMaterial();
        //3.倒入开水
        pullWater();
        //4.冲泡均匀
        brew();
    }

    public void boilWater(){
        System.out.println("烧开水");
    }

    //放入原料，因为不知道实际操作中放入的是什么原料，所以该方法为抽象方法，在实际使用的时候去实现
    public abstract void pullMaterial();

    public void pullWater(){
        System.out.println("倒入开水");
    }

    public void brew(){
        System.out.println("冲泡均匀");
    }
}
