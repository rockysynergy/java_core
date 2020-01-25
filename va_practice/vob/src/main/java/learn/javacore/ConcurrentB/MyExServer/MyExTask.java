package learn.javacore.ConcurrentB.MyExServer;

import java.util.Date;

class MyExTask extends Thread {
    private String name;

    public MyExTask(String name) {
        this.name = name;
    }

    public void run() {
        long v = (long) (Math.random() * 1000);
        System.out.println("The task: " + name + " is runnig for: " + v);
        try {
            Thread.sleep(v);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s: Task %s: Finished on: %s\n",Thread.currentThread().getName(),name,new Date());
    }
}