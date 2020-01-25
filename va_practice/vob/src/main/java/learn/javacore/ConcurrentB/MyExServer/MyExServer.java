package learn.javacore.ConcurrentB.MyExServer;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class MyExServer {
    private ThreadPoolExecutor ex;

    public MyExServer() {
        ex = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }

    public void submitTask(MyExTask task) {
        System.out.printf("Server: A new task has arrived\n");

        ex.execute(task);
        
		System.out.printf("Server: Pool Size: %d\n",ex.getPoolSize());
		System.out.printf("Server: Active Count: %d\n",ex.getActiveCount());
		System.out.printf("Server: Completed Tasks: %d\n",ex.getCompletedTaskCount());
    }

    public void shutdown() {
        ex.shutdown();
    }

}