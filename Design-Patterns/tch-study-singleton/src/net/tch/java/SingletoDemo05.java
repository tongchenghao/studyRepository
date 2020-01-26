/**
 * @description:枚举单例
 * @auth tongchenghao
 * @date 2020/1/26
 */
public enum SingletoDemo05 {
    INSTANCE;

    public static SingletoDemo05 getInstance(){
        return INSTANCE;
    }
}

class SingletoDemo05Test{
    public static void main(String[] args) {
        SingletoDemo05 instance = SingletoDemo05.getInstance();
        SingletoDemo05 instance1 = SingletoDemo05.getInstance();
        System.out.println(instance==instance1);
    }
}
