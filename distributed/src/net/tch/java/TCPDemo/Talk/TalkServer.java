package net.tch.java.TCPDemo.Talk;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:聊天服务器
 * @auth tongchenghao
 * @date 2020/2/10
 */
public class TalkServer {

    public static void main(String[] args) {
        Socket accept = null;
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            accept = serverSocket.accept();
            // 接收客户端信息
            InputStream inputStream = accept.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String input = "";

            // 接收控制台信息发送给客户端
            BufferedReader soutReader = new BufferedReader(new InputStreamReader(System.in));
            printWriter = new PrintWriter(accept.getOutputStream());

            String output = "";

            while (!output.equals("bye")){
                input = bufferedReader.readLine();// readLin会阻塞线程，直到读取到数据才会继续往下走
                if(input!=null&!input.equals("")){
                    System.out.println("Client:"+input);
                }
                output = soutReader.readLine();
                printWriter.println(output);
                printWriter.flush();
                System.out.println("Server:"+output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                accept.close();
                printWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
