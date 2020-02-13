package net.tch.java.TCPDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @auth tongchenghao
 * @date 2020/2/9
 */
public class ServerDemo {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        InputStream inputStream = null;
        try {
            serverSocket = new ServerSocket(8080);
            while (true){
                Socket accept = serverSocket.accept();
                inputStream = accept.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true){
                    String value = bufferedReader.readLine();
                    if(value==null||value.equals("")){
                        break;
                    }else{
                        System.out.println(value);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
