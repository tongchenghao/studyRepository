package Thread.demo1;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description:保存处理器
 * @auth tongchenghao
 * @date 2020/2/1
 */
public class SaveProcessor extends Thread implements RequestProcessor{
    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<>();


    @Override
    public void processorRequest(Request request) {
        linkedBlockingQueue.add(request);
    }

    @Override
    public void run() {
        while (true){
            try {
                Request request = linkedBlockingQueue.take();
                System.out.println("save:"+request.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
