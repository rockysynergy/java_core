package learn.javacore.ConcurrentB.ThreadCommunication.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 有家奶茶店，点单有时需要排队 假设想买奶茶的人如果看到需要排队，就决定不买
 */
class BuyMilk {
    private static final ReentrantLock queueLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        int STUDENTS_CNT = 10;
        BuyMilk buyMilk = new BuyMilk();

        Thread[] students = new Thread[STUDENTS_CNT];
        for (int i = 0; i < STUDENTS_CNT; i++) {
            students[i] = new Thread(new Runnable() {

                @Override
                public void run() {
                    long walkingTime = (long) (Math.random() * 1000);
                    try {
                        Thread.sleep(walkingTime);
                        buyMilk.tryToBuyMilkTea();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            students[i].start();
        }

        for (int i = 0; i < STUDENTS_CNT; i++) {
            students[i].join();
        }
    }

    protected void tryToBuyMilkTea() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            if (queueLock.tryLock()) {
                // queueLock.lock();
                long thinkingTime = (long) (Math.random() * 500);
                Thread.sleep(thinkingTime);
                System.out.println(Thread.currentThread().getName() + ": 来一杯珍珠奶茶，不要珍珠！！");
                flag = false;
                queueLock.unlock();
            } else {
                // System.out.println(Thread.currentThread().getName() + ": " + queueLock.getQueueLength() + "人在排队");
                System.out.println(Thread.currentThread().getName() + ": 再等等");
            }
            if (flag) {
                Thread.sleep(1000);
            }
        }
    }
}