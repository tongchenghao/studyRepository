package net.tch.java.RPC.myRPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * @description:服务请求处理器
 * @auth tongchenghao
 * @date 2020/2/13
 */
public class ProcessorHandler implements Runnable {

    Socket socket;
    Object service;

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            // 获取传输的数据
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            MyRpcRequest request = (MyRpcRequest) objectInputStream.readObject();
            // 执行请求
            Object result = invoke(request);
            // 返回结果给客户端
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            try {
                if (socket!=null){
                    socket.close();
                }
                if(objectInputStream!=null){
                    objectInputStream.close();
                }
                if(objectOutputStream!=null){
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 根据请求数据执行指定方法
     * @param request   请求数据
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object invoke(MyRpcRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 解析请求数据
        String className = request.getClassName();
        String methodName = request.getMethodName();
        Object[] arrgs = request.getArrgs();
        Class<?>[] types = new Class[arrgs.length];
        for (int i=0;i<arrgs.length;i++){
            types[i] = arrgs[i].getClass();
        }
        // 根据反射原理执行请求
        Method method = Class.forName(className).getMethod(methodName, types);
        Object result = method.invoke(service, arrgs);
        return result;
    }
}
