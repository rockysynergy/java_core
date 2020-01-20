package learn.javacore.ConcurentA.ProductConsumption;

class Consumer implements Runnable {

    private Storage storage;

    public Consumer(Storage s) {
        storage = s;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 5) {
            i++;
            storage.pop();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}