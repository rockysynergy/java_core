package learn.javacore.ConcurrentB.ThreadCommunication.Lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class Handleorder {

    private static final ReentrantReadWriteLock orderLock = new ReentrantReadWriteLock();

    /**
     * 假设奶茶店有老板和多名员工，记单方式比较原始，只有一个订单本 老板负责写新订单，员工不断地查看订单本得到信息来制作奶茶，在老板写新订单时员工不能看订单本
     * 多个员工可同时看订单本，在员工看时老板不能写新订单
     */
    public static void main(String[] args) {
        Handleorder handleorder = new Handleorder();

        Thread boss = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        handleorder.addOrder();
                        long waitingTime = (long) (Math.random() * 1000);
                        Thread.sleep(waitingTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        boss.start();

        int workerCnt = 3;
        Thread[] workers = new Thread[workerCnt];
        for (int i = 0; i < workerCnt; i++) {
            workers[i] = new Thread(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        try {
                            handleorder.viewOrder();
                            long workingTime = (long) (Math.random() * 5000);
                            Thread.sleep(workingTime);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            workers[i].start();
        }
    }

    protected void viewOrder() throws InterruptedException {
        orderLock.readLock().lock();

        long readingTime = (long) (Math.random() * 1000);
        Thread.sleep(readingTime);
        System.out.println(Thread.currentThread().getName() + ": 查看订单本");
        orderLock.readLock().unlock();
    }
    
    protected void addOrder() throws InterruptedException {
        orderLock.writeLock().lock();
        long writingTime = (long) (Math.random() * 1000);
        Thread.sleep(writingTime);
        System.out.println("老板新加一笔订单");
        orderLock.writeLock().unlock();
    }
}