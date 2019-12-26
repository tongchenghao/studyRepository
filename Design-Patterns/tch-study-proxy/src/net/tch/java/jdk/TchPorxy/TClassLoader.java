package jdk.TchPorxy;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @description:自己实现代理模式
 * @auth tongchenghao
 * @date 2019/12/25
 */
public class TClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //找到class文件并且读成字节数组
        String className = TPorxy.class.getPackage().getName() + name;
        String filePath = TPorxy.class.getResource("").getPath();
        File file = new File(filePath+name+".class");
        if(file.exists()){
            FileInputStream in = null;
            ByteOutputStream bos = null;
            try {
                in = new FileInputStream(file);
                bos = new ByteOutputStream();
                byte[] buff = new byte[1024];
                int len;
                while ((len=in.read(buff))!=-1){
                    bos.write(buff,0,len);
                }
                //将class的字节数组加载到JVM中
                return defineClass(className,bos.getBytes(),0,bos.size());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    in.close();
                    bos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bos.close();
            }
        }
        return null;
    }
}
