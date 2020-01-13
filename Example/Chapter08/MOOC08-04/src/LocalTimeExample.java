
import java.time.LocalTime;
import java.time.ZoneId;

public class LocalTimeExample {
 
    public static void main(String[] args) {
 
        //��ǰʱ��  ʱ���� ����
        LocalTime time = LocalTime.now();
        System.out.println("Current Time="+time);
 
        //����ʱ����
        LocalTime specificTime = LocalTime.of(12,20,25,40);
        System.out.println("Specific Time of Day="+specificTime);
 
        //�����ʱ����� ����DateTimeException
        //LocalTime invalidTime = LocalTime.of(25,20);
 
        //�Ϻ�ʱ��
        LocalTime timeSH = LocalTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("Current Time in SH="+timeSH);
 
        
        //һ�쵱�еڼ���
        LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
        System.out.println("10000th second time= "+specificSecondTime);
 
    }
 
}