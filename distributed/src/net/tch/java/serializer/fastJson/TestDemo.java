package net.tch.java.serializer.fastJson;

import net.tch.java.serializer.ISerializer;
import net.tch.java.serializer.entity.Hobby;
import net.tch.java.serializer.entity.User;

/**
 * @description:测试XfastJson序列化
 * @auth tongchenghao
 * @date 2020/2/12
 */
public class TestDemo {
    public static void main(String[] args) {
        User user = new User();
        Hobby hobby = new Hobby();
        user.setName("TCH");
        user.setSex("男");
        hobby.setHobbyName("swmming");
        user.setHobby(hobby);

        ISerializer serializer = new FastJsonSerializer();
        byte[] data = serializer.serializer(user);
        System.out.println(new String(data));

        User user2 = serializer.deserializer(data, User.class);

        System.out.println(user2==user);
        System.out.println(user2.getName());
        System.out.println(user2.getHobby()==user.getHobby());
        System.out.println(user2.getHobby().getHobbyName());

    }
}
