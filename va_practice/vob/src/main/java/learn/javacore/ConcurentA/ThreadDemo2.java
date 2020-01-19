package learn.javacore.ConcurentA;

/**
 * Call the object's start method will start the thread
 */
public class ThreadDemo2
{
	public static void main(String args[]) throws Exception
	{
		TestThread2 t = new TestThread2();
		t.start();
		while(true)
		{
			System.out.println("main thread is running");
			Thread.sleep(2000);
		}
	}
}

class TestThread2 extends Thread
{
	public void run() 
	{
		while(true)
		{
			System.out.println(" TestThread2 is running");
			try {
				Thread.sleep(2000); //2000毫秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}