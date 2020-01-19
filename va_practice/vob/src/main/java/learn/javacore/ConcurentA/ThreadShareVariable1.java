package learn.javacore.ConcurentA;

public class ThreadShareVariable1
{
	public static void main(String [] args)
	{
		new TestThreadSv0().start();
		new TestThreadSv0().start();
		new TestThreadSv0().start();
		new TestThreadSv0().start();
	}
}
class TestThreadSv0 extends Thread  
{
	//private int tickets=100;           //每个线程卖100张，没有共享
	private static int tickets=100;  //static变量是共享的，所有的线程共享
	public void run()
	{
		while(true)
		{
			if(tickets>0)
			{
				System.out.println(Thread.currentThread().getName() +
				" is selling ticket " + tickets);
				tickets = tickets - 1;
			}
			else
			{
				break;
			}
		}
	}
}