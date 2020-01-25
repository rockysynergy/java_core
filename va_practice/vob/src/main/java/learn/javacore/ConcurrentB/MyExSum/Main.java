package learn.javacore.ConcurrentB.MyExSum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor ex = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        List<Future<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Task calculator = new Task(i*100+1, (i+1)*100);
            Future<Integer> result = ex.submit(calculator);
            resultList.add(result);
        }

        // 每隔50毫秒，轮询等待10个任务结束
        do {
            System.out.printf("Main: 已经完成的任务数： %d\n", ex.getCompletedTaskCount());
            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                System.out.printf("Main: Task %d: %s\n", i, result.isDone());
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (ex.getCompletedTaskCount()<resultList.size());

        // 所有任务都已经结束了，综合计算结果
        int total = 0;
        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer sum = null;
            try {
                sum = result.get();
                total = total + sum;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("1-1000的总和: " + total);
    }
}