package learn.javacore.ConcurentA.ProductConsumption;

import java.util.Random;

class Producer implements Runnable{
    private Storage storage;

    public Producer(Storage s) {
        storage = s;
    }

    @Override
    public void run() {
        int i = 0;
        Random r = new Random();
        while (i < 5) {
            storage.push(new Product(r.nextInt()));
            i++;
        }
    }
}