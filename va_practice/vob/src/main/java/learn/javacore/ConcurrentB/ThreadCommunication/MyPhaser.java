package learn.javacore.ConcurrentB.ThreadCommunication;

import java.util.concurrent.Phaser;

class MyPhaser {

    /**
     * 假设举行考试，总共三道大题，每次下发一道题目，
     * 等所有学生完成后再进行下一道
     * @param args
     */
    public static void main(String[] args) {
        int studentCnt = 5;
        Phaser phaser = new Phaser(studentCnt);

        for (int i = 0; i < studentCnt; i++) {
            new Thread(new Student(phaser)).start();
        }
    }
}

class Student implements Runnable {
    private final Phaser phaser;

    Student (Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        try {
            doTesting(1);
            phaser.arriveAndAwaitAdvance();
            doTesting(2);
            phaser.arriveAndAwaitAdvance();
            doTesting(3);
            phaser.arriveAndAwaitAdvance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doTesting(int i) throws InterruptedException {
        String name = Thread.currentThread().getName();
        System.out.println(name + "开始第" + i + "题");
        long thinkingTime = (long) (Math.random() * 1000);
        Thread.sleep(thinkingTime);
        System.out.println(name + "第" + i + "道题答题结束");
    }
}