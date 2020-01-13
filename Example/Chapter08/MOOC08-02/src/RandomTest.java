

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) 
	{
		//��һ�ְ취������Random�� ���������int��Χ�ڵ������
		Random rd = new Random();
		System.out.println(rd.nextInt());
		System.out.println(rd.nextInt(100)); //0--100�������
		System.out.println(rd.nextLong());
		System.out.println(rd.nextDouble());		
		System.out.println("=========================");
		
		//�ڶ��֣�����һ����Χ�ڵ������ ����0��ʱ10֮��������
		//Math.random[0,1)
		System.out.println(Math.round(Math.random()*10));
		System.out.println("=========================");
		
		
		//JDK 8 ��������
        rd.ints();  //�������޸�int���ͷ�Χ�ڵ�����
        int[] arr = rd.ints(10).toArray();  //����10��int��Χ��ĸ�����
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("=========================");
		
        arr = rd.ints(5, 10, 100).toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        
        System.out.println("=========================");
        
        arr = rd.ints(10).limit(5).toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
	}

}
