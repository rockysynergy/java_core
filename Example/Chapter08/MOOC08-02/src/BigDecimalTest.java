import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal b1 = new BigDecimal("123456789.987654321"); // ����BigDecimal����
		BigDecimal b2 = new BigDecimal("987654321.123456789"); // ����BigDecimal����
		System.out.println("b1: " + b1 +  ", b2:" + b2);
		System.out.println("�ӷ�������" + b2.add(b1)); // �ӷ�����
		System.out.println("����������" + b2.subtract(b1)); // ��������
		System.out.println("�˷�������" + b2.multiply(b1)); // �˷�����
		//��Ҫָ��λ������ֹ����ѭ�������߰�����try-catch��
		System.out.println("����������" + b2.divide(b1,10,BigDecimal.ROUND_HALF_UP)); // ��������
		
		System.out.println("�������" + b2.max(b1)); // ��������
		System.out.println("��С����" + b2.min(b1)); // �����С��
		
		int flag = b1.compareTo(b2);
		if (flag == -1)
			System.out.println("�Ƚϲ���: b1<b2");
		else if (flag == 0)
			System.out.println("�Ƚϲ���: b1==b2");
		else
			System.out.println("�Ƚϲ���: b1>b2");
		
		System.out.println("===================");
		
		//���������ַ�����ֵ
		System.out.println(new BigDecimal("2.3"));
		System.out.println(new BigDecimal(2.3));
		
		System.out.println("===================");
		
		BigDecimal num1 = new BigDecimal("10");
		BigDecimal num2 = new BigDecimal("3");
		//��Ҫָ��λ������ֹ����ѭ�������߰�����try-catch��
		BigDecimal num3 = num1.divide(num2, 3, BigDecimal.ROUND_HALF_UP);
		System.out.println(num3);
	}
}
