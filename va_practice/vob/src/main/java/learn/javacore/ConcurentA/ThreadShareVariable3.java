package learn.javacore.ConcurentA;

public class ThreadShareVariable3
{
	public static void main(String args[]) throws Exception 
	{
		TestThreadSv2 t = new TestThreadSv2();
		t.start();
		Thread.sleep(2000);
		t.flag = false;
		System.out.println("main thread is exiting");
	}
}

class TestThreadSv2 extends Thread
{
	//boolean flag = true;   //子线程不会停止
	volatile boolean flag = true;  //用volatile修饰的变量可以及时在各线程里面通知
	public void run() 
	{
		int i=0;
		while(flag)
		{
			i++;			
		}
		System.out.println("test thread3 is exiting");
	}	
} 