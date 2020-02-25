package net.tch.dubbo;

/**
 * @description:使用dubbo提供的容器启动
 *      dubbo提供了spring的容器,jetty容器，Log4j容器
 * @auth tongchenghao
 * @date 2020/2/20
 */
public class Main {
    public static void main(String[] args) {
        com.alibaba.dubbo.container.Main.main(new String[]{"spring"});
    }
}
