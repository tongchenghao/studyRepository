package net.tch.java.serializer.fastJson;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.XStream;
import net.tch.java.serializer.ISerializer;

/**
 * @description:FastJson序列化
 * @auth tongchenghao
 * @date 2020/2/12
 */
public class FastJsonSerializer implements ISerializer {


    @Override
    public <T> byte[] serializer(T obj) {
        return JSON.toJSONBytes(obj);
    }

    @Override
    public <T> T deserializer(byte[] data, Class<T> clazz) {
        return (T)JSON.parseObject(new String(data),clazz);
    }
}
