package net.tch.java.serializer.entity;

import java.io.Serializable;

/**
 * @description:
 * @auth tongchenghao
 * @date 2020/2/12
 */
public class Hobby implements Serializable {

    private String hobbyName;

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }
}
