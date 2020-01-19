package learn.javacore.ConcurentA;

/**
 * Even the main thread finished, the sub-thread still runging
 */
public class ThreadDemo3
{
	public static void main(String args[]) throws InterruptedException
	{
		new TestThread3().start();
//		while(true)
//		{
//			System.out.println("main thread is running");
//			Thread.sleep(1000);
//		}
	}
}
 class TestThread3 extends Thread
{
	public void run() 
	{
		while(true)
		{
			System.out.println("TestThread3" + "　is running");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
} 