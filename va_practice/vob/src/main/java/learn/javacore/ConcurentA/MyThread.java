package learn.javacore.ConcurentA;

class MyThread {
    public static void main(String[] args) {
        MyThreadCe t = new MyThreadCe();
        t.start();
        MyThreadCe t1 = new MyThreadCe();
        t1.start();
        while (true) {
            System.out.println("++++ I am in main!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class MyThreadCe extends Thread {
    public void run() {
        while (true) {
            System.out.println(">>>> I am in Thread!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}