package net.tch.java.serializer;

/**
 * @description:序列化接口
 * @auth tongchenghao
 * @date 2020/2/12
 */
public interface ISerializer {

    /**
     * 序列化
     * @param obj
     * @param <T>
     * @return
     */
    <T> byte[] serializer(T obj);

    /**
     * 反序列化
     * @param data
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T deserializer(byte[] data,Class<T> clazz);
}
