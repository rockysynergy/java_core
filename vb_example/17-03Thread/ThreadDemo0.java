
public class ThreadDemo0
{
	public static void main(String [] args)
	{
		new TestThread0().start();
		new TestThread0().start();
		new TestThread0().start();
		new TestThread0().start();
	}
}
class TestThread0 extends Thread  
{
	//private int tickets=100;           //ÿ���߳���100�ţ�û�й���
	private static int tickets=100;  //static�����ǹ���ģ����е��̹߳���
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
