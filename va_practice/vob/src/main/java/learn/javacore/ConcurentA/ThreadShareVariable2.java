package learn.javacore.ConcurentA;

public class ThreadShareVariable2
{
	public static void main(String [] args)
	{
		TestThreadSv1 t=new TestThreadSv1();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
	}
}
class TestThreadSv1 implements Runnable
{
	private int tickets=100;
	public void run()
	{
		while(true)
		{
			if(tickets>0)
			{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				tickets--;
				System.out.println(Thread.currentThread().getName() +" is selling ticket " + tickets);
			}
			else
			{
				break;
			}
				
		}
	}
}