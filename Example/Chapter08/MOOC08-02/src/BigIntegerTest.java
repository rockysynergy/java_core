import java.math.BigInteger;

public class BigIntegerTest {

	public static void main(String[] args) {
		BigInteger b1 = new BigInteger("123456789"); // ����BigInteger����
		BigInteger b2 = new BigInteger("987654321"); // ����BigInteger����
		System.out.println("b1: " + b1 +  ", b2:" + b2);
		System.out.println("�ӷ�������" + b2.add(b1)); // �ӷ�����
		System.out.println("����������" + b2.subtract(b1)); // ��������
		System.out.println("�˷�������" + b2.multiply(b1)); // �˷�����
		System.out.println("����������" + b2.divide(b1)); // ��������
		System.out.println("�������" + b2.max(b1)); // ��������
		System.out.println("��С����" + b2.min(b1)); // �����С��
		BigInteger result[] = b2.divideAndRemainder(b1); // ��������ĳ�������
		System.out.println("���ǣ�" + result[0] + "�������ǣ�" + result[1]);
		System.out.println("�ȼ����ǣ�" + b1.equals(b2));
		int flag = b1.compareTo(b2);
		if (flag == -1)
			System.out.println("�Ƚϲ���: b1<b2");
		else if (flag == 0)
			System.out.println("�Ƚϲ���: b1==b2");
		else
			System.out.println("�Ƚϲ���: b1>b2");

	}
}
