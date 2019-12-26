package bean;

/**
 * @description:奥迪车
 * @auth tongchenghao
 * @date 2019/12/26
 */
public class AoDi implements Car{

    private String descript = "我是奥迪车子";

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
