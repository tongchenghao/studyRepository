package net.tch.java.TCPDemo.ThreadTalk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @description:
 * @auth tongchenghao
 * @date 2020/2/10
 */
public class InputThread extends Thread{

    private Socket socket;

    public InputThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                String inputValue = bufferedReader.readLine();
                if(inputValue!=null&&!inputValue.equals("bye")){
                    System.out.println("Client:"+inputValue);
                }else{
                    System.out.println("Client:"+"我准备断开连接了");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
                if(socket!=null){
                    socket.close();
                }
                System.out.println("已经断开输入连接");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
