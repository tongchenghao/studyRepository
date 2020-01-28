package dome2;

import java.io.*;

/**
 * @description:猴子
 * @auth tongchenghao
 * @date 2020/1/28
 */
public class Monkey implements Cloneable,Serializable{

    int height;

    int weight;

    Variety variety;

    Tribe tribe;

    public Monkey(int height, int weight, Variety variety, Tribe tribe) {
        this.height = height;
        this.weight = weight;
        this.variety = variety;
        this.tribe = tribe;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Variety getVariety() {
        return variety;
    }

    public void setVariety(Variety variety) {
        this.variety = variety;
    }

    public Tribe getTribe() {
        return tribe;
    }

    public void setTribe(Tribe tribe) {
        this.tribe = tribe;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object copy = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            copy = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return copy;
    }
}
