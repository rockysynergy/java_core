package learn.javacore.ConcurrentB.MyExServer;

class Main {
    public static void main(String[] args) throws InterruptedException {
        MyExServer server = new MyExServer();

        for (int i = 0; i < 100; i++) {
            MyExTask tsk = new MyExTask("+++++++++++++++++++++++Task " + i);
            Thread.sleep(1000);
            server.submitTask(tsk);
        }

        server.shutdown();
    }
}