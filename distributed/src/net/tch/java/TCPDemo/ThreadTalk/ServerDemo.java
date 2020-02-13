package net.tch.java.TCPDemo.ThreadTalk;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @auth tongchenghao
 * @date 2020/2/10
 */
public class ServerDemo {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            new InputThread(socket).start();
            new OutputThread(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
