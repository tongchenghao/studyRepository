/**
 * @description:饮料机测试
 * @auth tongchenghao
 * @date 2020/1/28
 */
public class BeverageTest {
    public static void main(String[] args) {
        System.out.println("开始冲泡咖啡");
        Coffee coffee = new Coffee();
        coffee.create();
        System.out.println("-----------------------------------");
        System.out.println("开始冲泡茶");
        Tea tea = new Tea();
        tea.create();
    }
}
