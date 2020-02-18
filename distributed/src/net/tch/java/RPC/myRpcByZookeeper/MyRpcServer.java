package net.tch.java.RPC.myRpcByZookeeper;

import net.tch.java.RPC.myRpcByZookeeper.anno.MyRpcAnnotation;
import net.tch.java.RPC.myRpcByZookeeper.registerCenter.IRegisterCenter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
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

    // 注册中心
    IRegisterCenter registerCenter;
    // 服务地址
    String serviceAddress;

    // 存放服务名称和服务对象之间的关系
    Map<String,Object> handleMap = new HashMap<>();

    public MyRpcServer(IRegisterCenter registerCenter, String serviceAddress) {
        this.registerCenter = registerCenter;
        this.serviceAddress = serviceAddress;
    }

    /**
     * 绑定服务到其对应的服务名称
     * @param services
     */
    public void bind(Object... services){
        for (Object service : services){
            // 获取服务的对应的接口地址
            MyRpcAnnotation annotation = service.getClass().getAnnotation(MyRpcAnnotation.class);
            String serviceName = annotation.value().getName();
            // 如果存在版本号则为服务名称加上版本号
            String version = annotation.version();
            if(version!=null&&!version.equals("")){
                serviceName = serviceName+"-"+version;
            }
            // 接口地址绑定到对应服务
            handleMap.put(serviceName,service);
        }
    }

    /**
     * 发布服务到对应端口
     */
    public void publisher(){
        ServerSocket serverSocket = null;
        try {
            String[] addrs = serviceAddress.split(":");
            // 启动一个服务监听
            serverSocket = new ServerSocket(Integer.valueOf(addrs[1]));

            // 将对应服务注册到注册中心
            for (String interfaceName :
                    handleMap.keySet()) {
                registerCenter.register(interfaceName,serviceAddress);
                System.out.println("服务注册成功："+interfaceName+"->"+serviceAddress);
            }
            
            while (true){
                // 获取连接
                Socket socket = serverSocket.accept();
                // 获取到连接后开启一个线程处理请求
                executorService.submit(new ProcessorHandler(socket,handleMap));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
