package learn.javacore.ConcurrentB.ThreadCommunication;

import java.util.concurrent.CountDownLatch;

class CountDownLatchExample
{
    /**
     * 设想百米赛跑比赛 发令枪发出信号后选手开始跑， 全部选手跑到终点后比赛结束
     * 
     * @throws InterruptedException
     * 
     */
    public static void main(String[] args) throws InterruptedException {
       int runnerCnt = 10;
       CountDownLatch startsignal = new CountDownLatch(1);
       CountDownLatch doneSignal = new CountDownLatch(runnerCnt);

       for (int i = 0; i < runnerCnt; i++) {
           // create and start threads
           new Thread(new Worker(startsignal, doneSignal)).start();
       }

       System.out.println("准备工作。。。");
       System.out.println("准备工作就绪");
       startsignal.countDown();
       System.out.println("比赛开始");
       doneSignal.await();
       System.out.println("比赛结束");
    }

    static class Worker implements Runnable {
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try {
                startSignal.await();
                doWork();
                doneSignal.countDown();
            } catch (InterruptedException e) {
                //
            }
        }

        private void doWork() {
            System.out.println(Thread.currentThread().getName() + "跑完全程");
        }
    }
}