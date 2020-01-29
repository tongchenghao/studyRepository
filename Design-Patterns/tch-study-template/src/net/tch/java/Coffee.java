/**
 * @description:使用饮料机制作咖啡
 * @auth tongchenghao
 * @date 2020/1/28
 */
public class Coffee extends Beverage {
    @Override
    public void pullMaterial() {
        System.out.println("放入咖啡豆");
    }
}
