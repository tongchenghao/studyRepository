package net.tch.java.RPC.myRPC;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:我的rpc框架的服务端
 *      服务发布器
 * @auth tongchenghao
 * @date 2020/2/13
 */
public class MyRpcServer {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    /**
     * 发布服务到对应端口
     * @param service
     * @param port
     */
    public void publisher(Object service, int port){
        ServerSocket serverSocket = null;
        try {
            // 创建服务
            serverSocket = new ServerSocket(port);
            while (true){
                // 获取连接
                Socket socket = serverSocket.accept();
                // 获取到连接后开启一个线程处理请求
                executorService.submit(new ProcessorHandler(socket,service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
