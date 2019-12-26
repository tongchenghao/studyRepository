package jdk.TchPorxy;


import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Method;

/**
 * @description:自己实现代理模式
 * @auth tongchenghao
 * @date 2019/12/24
 */
public class TPorxy {
    public static Object newProxyInstance(TClassLoader loader,
                                          Class<?>[] TInvocationHandler,
                                          TInvocationHandler h)
            throws IllegalArgumentException{
        //1.动态生成代理对象代码
        String srcCode = generateSrc(TInvocationHandler);
        //2.生成的java文件保存到磁盘中
        String filePath = TPorxy.class.getResource("").getPath();
        File file = new File(filePath+"$TPorxy0.java");
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(srcCode);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3.编译代码为class
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> javaFileObjects = manager.getJavaFileObjects(file);

        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, javaFileObjects);
        task.call();
        try {
            manager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.获取编译后的class的字节数组并动态加载到JVM中
        Class<?> $Porxy0 = null;
        try {
            $Porxy0 = loader.findClass("$Porxy0");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //5.返回生成的对象实例
        return $Porxy0;
    }


    /**
     * 通过interface动态生成代码
     * TODO 还未写完，逻辑比较复杂
     * @param interfaces
     * @return
     */
    public static String generateSrc(Class<?>[] interfaces){
        StringBuffer sb = new StringBuffer();
        sb.append("import java.lang.reflect.InvocationHandler;\n" );
        sb.append("import java.lang.reflect.Method;\n" );
        sb.append("import java.lang.reflect.Proxy;\n" );
        sb.append("import java.lang.reflect.UndeclaredThrowableException;\n" );

        sb.append("public final class $Proxy0 extends "+TPorxy.class.getName()+" implements ");
        for (int i=0;i<interfaces.length;i++){
            sb.append(interfaces[i].getName());
        }
        sb.append("{\n" );
        sb.append("public $Proxy0(TInvocationHandler var1) throws  {\n" +
                "        super(var1);\n" +
                "    }");

        for (int i=0;i<interfaces.length;i++) {
            Method[] methods = interfaces[i].getMethods();
            for (int j=0;i<methods.length;j++) {
                methods[j].getParameterTypes();
                sb.append("public final "+methods[j].getReturnType()+" "+methods[j].getName()+"(Object var1) throws  {\n" +
                        "        try {\n" +
                        "            return (Boolean)super.h.invoke(this, m1, new Object[]{var1});\n" +
                        "        } catch (RuntimeException | Error var3) {\n" +
                        "            throw var3;\n" +
                        "        } catch (Throwable var4) {\n" +
                        "            throw new UndeclaredThrowableException(var4);\n" +
                        "        }\n" +
                        "    }");
            }
        }

        sb.append("}");

        System.out.println(sb.toString());
        return null;
    }

}
