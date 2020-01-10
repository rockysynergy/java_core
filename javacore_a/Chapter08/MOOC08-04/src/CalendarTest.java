import java.util.Calendar;

public class CalendarTest {
	
	Calendar calendar = Calendar.getInstance();
	
	public void test1() {
        // ��ȡ��
        int year = calendar.get(Calendar.YEAR);
        // ��ȡ�£�������Ҫ��Ҫ�·ݵķ�ΧΪ0~11����˻�ȡ�·ݵ�ʱ����Ҫ+1���ǵ�ǰ�·�ֵ
        int month = calendar.get(Calendar.MONTH) + 1;
        // ��ȡ��
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // ��ȡʱ
        int hour = calendar.get(Calendar.HOUR);
        // int hour = calendar.get(Calendar.HOUR_OF_DAY); // 24Сʱ��ʾ
        // ��ȡ��
        int minute = calendar.get(Calendar.MINUTE);
        // ��ȡ��
        int second = calendar.get(Calendar.SECOND);

        // ���ڣ�Ӣ��������ڴ������տ�ʼ����
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println("������" + year + "��" + month + "��" + day + "��" + hour
                + "ʱ" + minute + "��" + second + "��" + "����" + weekday);
    }

    // һ���Ľ���
    public void test2() {
        // ͬ�����¸��µĽ���calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.YEAR, 1);

        // ��ȡ��
        int year = calendar.get(Calendar.YEAR);
        // ��ȡ��
        int month = calendar.get(Calendar.MONTH) + 1;
        // ��ȡ��
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("һ���Ľ��죺" + year + "��" + month + "��" + day + "��");
    }

    // ��ȡ����һ���µ����һ��
    public void test3() {
        // ������6�µ����һ��
        int currentMonth = 6;
        // �����7�·ݵĵ�һ�죬ʵ��������6Ϊ�ⲿ���ݽ�����currentMonth����
        // 1
        calendar.set(calendar.get(Calendar.YEAR), currentMonth, 1);

        calendar.add(Calendar.DATE, -1);

        // ��ȡ��
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("6�·ݵ����һ��Ϊ" + day + "��");
    }

    // ��������
    public void test4() {
        calendar.set(Calendar.YEAR, 2000);
        System.out.println("������" + calendar.get(Calendar.YEAR) + "��");

        calendar.set(2018, 7, 8);
        // ��ȡ��
        int year = calendar.get(Calendar.YEAR);
        // ��ȡ��
        int month = calendar.get(Calendar.MONTH)+1;
        // ��ȡ��
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("������" + year + "��" + month + "��" + day + "��");
    }
    
    //add��roll������
    public void test5() {     

        calendar.set(2018, 7, 8);
        calendar.add(Calendar.DAY_OF_MONTH, -8);
        
        // ��ȡ��
        int year = calendar.get(Calendar.YEAR);
        // ��ȡ��
        int month = calendar.get(Calendar.MONTH)+1;
        // ��ȡ��
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("2018.8.8, ��add����8�죬������" + year + "." + month + "." + day);
        
        calendar.set(2018, 7, 8);
        calendar.roll(Calendar.DAY_OF_MONTH, -8);
        
        // ��ȡ��
        year = calendar.get(Calendar.YEAR);
        // ��ȡ��
        month = calendar.get(Calendar.MONTH)+1;
        // ��ȡ��
        day = calendar.get(Calendar.DAY_OF_MONTH);

        System.out.println("2018.8.8, ��roll����8�죬������" + year + "." + month + "." + day);
    }
    
    
	public static void main(String[] args) {
		CalendarTest c = new CalendarTest();
		c.test1();
		System.out.println("============");
		c.test2();
		System.out.println("============");
		c.test3();
		System.out.println("============");
		c.test4();
		System.out.println("============");
		c.test5();

	}

}
