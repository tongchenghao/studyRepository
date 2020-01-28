package dome2;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:猴子的部落
 * @auth tongchenghao
 * @date 2020/1/28
 */
public class Tribe implements Serializable {

    String name;

    //规模
    Integer scale;

    //食物数量
    int foodNum;

    //创建时间
    Date createDate;

    public Tribe(String name, Integer scale, int foodNum, Date createDate) {
        this.name = name;
        this.scale = scale;
        this.foodNum = foodNum;
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public int getFoodNum() {
        return foodNum;
    }

    public void setFoodNum(int foodNum) {
        this.foodNum = foodNum;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
