package Thread.demo1;

/**
 * @description:进程测试
 * @auth tongchenghao
 * @date 2020/2/1
 */
public class DomeMain {



    public static void main(String[] args) {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        PrintProcessor printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();

        Request request = new Request();
        request.setName("tch");

        printProcessor.processorRequest(request);
        //先输出1，再输出进程中的代码
        System.out.println("1");
        //运行后进程还未结束
    }
}
