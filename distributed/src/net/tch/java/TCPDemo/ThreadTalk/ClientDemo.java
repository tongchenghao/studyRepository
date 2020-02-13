package net.tch.java.TCPDemo.ThreadTalk;

import java.io.IOException;
import java.net.Socket;

/**
 * @description:
 * @auth tongchenghao
 * @date 2020/2/10
 */
public class ClientDemo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8080);
            new InputThread(socket).start();
            new OutputThread(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
