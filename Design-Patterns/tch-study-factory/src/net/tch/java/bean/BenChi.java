package bean;

/**
 * @description:奔驰
 * @auth tongchenghao
 * @date 2019/12/26
 */
public class BenChi implements Car{
    private String descript = "我是奔驰车子";

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
