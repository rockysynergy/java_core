
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
 
public class InstantExample {
 
    public static void main(String[] args) {
        //��ǰʱ���
        Instant timestamp = Instant.now();
        System.out.println("Current Timestamp = "+timestamp);
 
        //�Ӻ�����������ʱ���
        Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific Time = "+specificTime);
 
        Date date = Date.from(timestamp); 
        System.out.println("current date = " + date);
    }
 
}