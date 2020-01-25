package learn.javacore.ConcurrentB.MyExSum;

import java.util.Random;
import java.util.concurrent.Callable;

class Task implements Callable<Integer> {
    private Integer start;
    private Integer end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }

        Thread.sleep(new Random().nextInt(1000));
        System.out.printf("%s: %d\n",Thread.currentThread().getName(),sum);
		return sum;
    }

}