package net.tch.java.serializer.xmlSerializer;

import com.thoughtworks.xstream.XStream;
import net.tch.java.serializer.ISerializer;

/**
 * @description:XML序列化
 * @auth tongchenghao
 * @date 2020/2/12
 */
public class XmlSerializer implements ISerializer {

    XStream xStream = new XStream();
    @Override
    public <T> byte[] serializer(T obj) {
        return xStream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deserializer(byte[] data, Class<T> clazz) {
        return (T)xStream.fromXML(new String(data));
    }
}
