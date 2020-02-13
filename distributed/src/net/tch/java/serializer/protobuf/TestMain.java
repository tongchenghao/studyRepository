package net.tch.java.serializer.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import net.tch.java.serializer.ISerializer;
import net.tch.java.serializer.entity.Hobby;
import net.tch.java.serializer.entity.User;
import net.tch.java.serializer.fastJson.FastJsonSerializer;

/**
 * @description:protoBuf序列化测试
 * @auth tongchenghao
 * @date 2020/2/12
 */
public class TestMain {
    public static void main(String[] args) {

        UserProto.User user = UserProto.User.newBuilder().setName("TCH").setSex("男").build();

        byte[] bytes = user.toByteArray();
        System.out.println("-------------");
        System.out.println(new String(bytes));
        System.out.println("-------------");
        try {
            UserProto.User user2= UserProto.User.parseFrom(bytes);

            System.out.println(user2);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
