package learn.javacore.ConcurentA;

public class ThreadShareVariable4 {
	public static void main(String[] args) {
		TestThreadSv3 t = new TestThreadSv3();
		Thread t1 = new Thread(t, "Thread-0");
		t1.start();
		Thread t2 = new Thread(t, "Thread-1");
		t2.start();
		Thread t3 = new Thread(t, "Thread-2");
		t3.start();
		Thread t4 = new Thread(t, "Thread-3");
		t4.start();
	}
}

class TestThreadSv3 implements Runnable {
	private volatile int tickets = 100; // 多个 线程在共享的
	String str = new String("");

	public void run() {
		while (true) {
			sale();
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			if (tickets <= 0) {
				break;
			}
		}

	}

	public synchronized void sale() { // 同步函数
		if (tickets > 0) {
			System.out.println(Thread.currentThread().getName() + " is saling ticket " + tickets--);
		}
	}
}