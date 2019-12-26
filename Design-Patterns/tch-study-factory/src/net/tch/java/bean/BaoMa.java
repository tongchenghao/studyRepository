package bean;

/**
 * @description:宝马车
 * @auth tongchenghao
 * @date 2019/12/26
 */
public class BaoMa implements Car{
    private String descript = "我是宝马车子";

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    @Override
    public void descriptSelf() {
        System.out.println(descript);
    }
}
