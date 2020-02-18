package net.tch.java.RPC.myRpcByZookeeper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @description:TCP传输层，实现了基于socket的TCP请求
 * @auth tongchenghao
 * @date 2020/2/13
 */
public class MyRpcTCPTransport {

    private String servicePath;

    public MyRpcTCPTransport(String servicePath) {
        this.servicePath = servicePath;
    }

    /**
     * 创建连接
     * @return
     * @throws Exception
     */
    public Socket newSocket() throws Exception {
        Socket socket = null;
        try {
            // 根据servicePath获取ip和端口号
            String[] servicePathArr = servicePath.split(":");
            socket = new Socket(servicePathArr[0],Integer.valueOf(servicePathArr[1]));
            return socket;
        } catch (IOException e) {
            throw new Exception("连接创建失败",e);
        }
    }

    /**
     * 发送请求到服务端，并返回服务端获取的数据
     * @param request
     * @return
     * @throws Exception
     */
    public Object send(MyRpcRequest request) throws Exception {
        Socket socket = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            // 建立与服务端的连接
            socket = newSocket();
            // 发送请求
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();
            // 等待结果
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object result = objectInputStream.readObject();
            return result;
        }finally {
            if (socket!=null){
                socket.close();
            }
            if (objectOutputStream!=null){
                objectOutputStream.close();
            }
            if (objectInputStream!=null){
                objectInputStream.close();
            }
        }
    }
}
