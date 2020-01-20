package learn.javacore.ConcurentA.ProductConsumption;

class ProductTester {
    public static void main(String[] args) throws InterruptedException {
        Storage s = new Storage();
        Thread p__1 = new Thread(new Producer(s));
        p__1.setName("Producer_1");
        Thread p__2 = new Thread(new Producer(s));
        p__2.setName("Producer_2");

        Thread c__1 = new Thread(new Consumer(s));
        c__1.setName("consumber__1");
        Thread c__2 = new Thread(new Consumer(s));
        c__2.setName("consumber__2");

        p__1.start();
        p__2.start();
        Thread.sleep(1000);
        c__1.start();
        c__2.start();
    }
}