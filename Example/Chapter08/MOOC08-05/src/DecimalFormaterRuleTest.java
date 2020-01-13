import java.text.DecimalFormat;

public class DecimalFormaterRuleTest {
	public static void main(String[]args){
        
        DecimalFormat df1,df2;
         
        System.out.println("��������Ϊ0�������0/#������");
        // ��������Ϊ0 �� #��Ϊ���������ڣ��ɲ�д�� 0��Ϊû�У�������дһλ��д0
        df1 = new DecimalFormat("#.00");
        df2 = new DecimalFormat("0.00");
         
        System.out.println(df1.format(0.1)); // .10  
        System.out.println(df2.format(0.1)); // 0.10  
         
        System.out.println("С������0/#������");
        //#��������м�λ��0�����������ֻ���м�λ
        df1 = new DecimalFormat("0.00");
        df2 = new DecimalFormat("0.##");
         
        System.out.println(df1.format(0.1)); // 0.10
        System.out.println(df2.format(0.1)); // 0.1
         
        System.out.println(df1.format(0.006)); // 0.01
        System.out.println(df2.format(0.006)); // 0.01
         
        System.out.println("���������ж�λ");
        //0��#���������ֶ�λʱ�Ĵ�����һ�µ� �����м�λд����λ
        df1 = new DecimalFormat("0.00");
        df2 = new DecimalFormat("#.00");
         
        System.out.println(df1.format(2)); // 2.00
        System.out.println(df2.format(2)); // 2.00
         
        System.out.println(df1.format(20)); // 20.00
        System.out.println(df2.format(20)); // 20.00
         
        System.out.println(df1.format(200)); // 200.00
        System.out.println(df2.format(200)); // 200.00
         
         
    }
}
