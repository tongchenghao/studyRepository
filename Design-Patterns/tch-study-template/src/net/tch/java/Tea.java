/**
 * @description:使用饮料机制作茶
 * @auth tongchenghao
 * @date 2020/1/28
 */
public class Tea extends Beverage {

    @Override
    public void pullMaterial() {
        System.out.println("放入茶叶");
    }
}
