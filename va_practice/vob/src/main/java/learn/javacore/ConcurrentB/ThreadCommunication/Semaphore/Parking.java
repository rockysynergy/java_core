package learn.javacore.ConcurrentB.ThreadCommunication.Semaphore;

import java.util.concurrent.Semaphore;

class Parking {

    private final Semaphore pSemaphore = new Semaphore(5);

    public static void main(String[] args) throws InterruptedException {
        int tryCnt = 10;

        Parking parking = new Parking();
        Thread[] parkers = new Thread[tryCnt];

        for (int i = 0; i < tryCnt; i++) {
            parkers[i] = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        long rTime = (long) (Math.random() * 1000);
                        Thread.sleep(rTime);
                        if (parking.parking()) {
                            long pTime = (long) (Math.random() * 1200);
                            Thread.sleep(pTime);
                            parking.leaving();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            parkers[i].start();
        }

        for (int i = 0; i < tryCnt; i++) {
            parkers[i].join();
        }
    }

    protected void leaving() {
        pSemaphore.release();
        System.out.println(Thread.currentThread().getName() + ": 开走");
    }

    protected boolean parking() {
        if (pSemaphore.tryAcquire()) {
            System.out.println(Thread.currentThread().getName() + ": 停车成功");
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + ":没有空位");
            return false;
        }
    }
}