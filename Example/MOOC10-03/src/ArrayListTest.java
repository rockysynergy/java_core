import java.util.ArrayList;
import java.util.Iterator;
//Vector ������ArrayListһ��������Vector������ͬ����

public class ArrayListTest {
	public static void main(String[] a) {  
	    ArrayList<Integer> al = new ArrayList<Integer>();  
	    al.add(3);  
	    al.add(2);          
	    al.add(1);  
	    al.add(4);  
	    al.add(5);  
	    al.add(6);  
	    al.add(new Integer(6));  
	  
	    System.out.print("The third element is  ");
	    System.out.println(al.get(3));
	    al.remove(3);  //ɾ�����ĸ�Ԫ�أ�����Ԫ����ǰŲ��
	    al.add(3, 9);  //��9���뵽��4��Ԫ�أ�����Ԫ������Ų��
	    
	    System.out.println("======��������=============");
	    
	    ArrayList<Integer> as = new ArrayList<Integer>(100000);
	    for (int i=0; i<100000; i++)
	    {
	    	as.add(i);
	    }
	    traverseByIterator(as);
	    traverseByIndex(as);
	    traverseByFor(as);    
	}  
	public static void traverseByIterator(ArrayList<Integer> al)
	{
		long startTime = System.nanoTime();
		System.out.println("============����������=============="); 
	    Iterator<Integer> iter1 = al.iterator();  
	    while(iter1.hasNext()){  
	        iter1.next();  
	    }
		long endTime = System.nanoTime();
	    long duration = endTime - startTime;
	    System.out.println(duration + "����");
	}
	public static void traverseByIndex(ArrayList<Integer> al)
	{
		long startTime = System.nanoTime();
		System.out.println("============�������ֵ����=============="); 
	    for(int i=0;i<al.size();i++)
	    {
	    	al.get(i);
	    }
		long endTime = System.nanoTime();
	    long duration = endTime - startTime;
	    System.out.println(duration + "����");
	}
	public static void traverseByFor(ArrayList<Integer> al)
	{
		long startTime = System.nanoTime();
		System.out.println("============forѭ������=============="); 
	    for(Integer item : al)
	    {
	    	;
	    }
		long endTime = System.nanoTime();
	    long duration = endTime - startTime;
	    System.out.println(duration + "����");
	}
}
