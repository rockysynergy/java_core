package learn.javacore.ConcurrentB.ThreadCommunication;

import java.util.Scanner;
import java.util.concurrent.Exchanger;

class MyExchanger {

    /**
     * 本例通过Exchanger实现学生成绩查询，简单线程间数据的交换
     * 
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<String>();
        BackgroundWorker worker = new BackgroundWorker(exchanger);
        new Thread(worker).start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("输入要查询的学生姓名：");
            String input = scanner.nextLine().trim();
            exchanger.exchange(input);
            String value = exchanger.exchange(null);
            if ("exit".equals(value)) {
                break;
            }
            System.out.println("查询结果：" + value);
        }
        scanner.close();
    }
}

class BackgroundWorker implements Runnable {
    final Exchanger<String> exchanger;

    BackgroundWorker(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String item = exchanger.exchange(null);
                switch (item) {
                    case "zs":
                        exchanger.exchange("90");
                        break;
                    case "ls":
                        exchanger.exchange("80");
                        break;
                    case "ww":
                        exchanger.exchange("70");
                        break;
                    case "exit":
                        exchanger.exchange("exit");
                        return;
                    default:
                        exchanger.exchange("查无此人");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}