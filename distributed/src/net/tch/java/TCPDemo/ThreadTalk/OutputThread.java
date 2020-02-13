package net.tch.java.TCPDemo.ThreadTalk;

import java.io.*;
import java.net.Socket;

/**
 * @description:
 * @auth tongchenghao
 * @date 2020/2/10
 */
public class OutputThread extends Thread{
    private volatile Socket socket;

    public OutputThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            OutputStream outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            while (true){
                printWriter.println(bufferedReader.readLine());
                printWriter.flush();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (socket!=null){
                    socket.close();
                }
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
                if(printWriter!=null){
                    printWriter.close();
                }
                System.out.println("已经断开输出连接");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
