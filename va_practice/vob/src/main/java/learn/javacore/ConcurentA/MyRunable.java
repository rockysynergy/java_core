package learn.javacore.ConcurentA;

class MyRunable {
    public static void main(String[] args) {
        TeRunable te = new TeRunable();
        Thread t = new Thread(te);
        t.start();

        Thread t2 = new Thread(te);
        t2.start();

        while (true) {
            System.out.println("++++ I am in main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TeRunable implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName());
            System.out.println(">>>>>> I am in thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}