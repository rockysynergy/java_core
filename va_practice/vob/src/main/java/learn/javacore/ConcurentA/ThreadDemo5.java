package learn.javacore.ConcurentA;

public class ThreadDemo5
{
	public static void main(String [] args)
	{
		TestThread5 t=new TestThread5();
		t.start();
		//t.start();
		//t.start();
		//t.start();
		TestThread5 t1=new TestThread5();
		t1.start();		
	}
}

class TestThread5 extends Thread  
{
	public void run()
	{
		while(true)
		{
			System.out.println(Thread.currentThread().getName() +
			" is running");
			try {
				Thread.sleep(1000); //1000毫秒
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
