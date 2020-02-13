package net.tch.java.TCPDemo.Talk;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:聊天客户端
 * @auth tongchenghao
 * @date 2020/2/10
 */
public class TalkClient {

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try {
            socket = new Socket("127.0.0.1",8080);

            // 接收控制台信息发送给服务端端
            BufferedReader soutReader = new BufferedReader(new InputStreamReader(System.in));
            String output = soutReader.readLine();// readLin会阻塞线程，直到读取到数据才会继续往下走
            System.out.println(output);
            printWriter = new PrintWriter(socket.getOutputStream());

            // 接收服务端信息
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);


            while (!output.equals("bye")){
                printWriter.println(output);
                printWriter.flush();
                System.out.println("Client:"+output);

                String input = bufferedReader.readLine();
                if(input!=null&!input.equals("")){
                    System.out.println("Server:"+input);
                }
                output = soutReader.readLine();// readLin会阻塞线程，直到读取到数据才会继续往下走
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
                printWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
