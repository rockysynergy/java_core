import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("123456789.987654321");
        BigDecimal b2 = new BigDecimal("987654321.123456789");
        System.out.println("b1: " + b1 + ", b2: " + b2);
        System.out.println("add: " + b2.add(b1));
        System.out.println("sub: " + b2.subtract(b1));
        System.out.println("multiply: " + b2.multiply(b1));
        //需要指定位数， 防止无限循环，或者包含在try-catch中
        System.out.println("divide" + b2.divide(b1, 10, RoundingMode.HALF_UP));

        System.out.println("max: " + b2.max(b1));
        System.out.println("min: " + b2.min(b1));

        int flag = b1.compareTo(b2);
        if (flag == -1)
            System.out.println("compare: b1 < b2");
        else if (flag == 0)
            System.out.println("compare b1 == b2");
        else 
            System.out.println("compare b1 > b2");

        System.out.println("===========================");
        // 尽量采用字符串赋值
        System.out.println(new BigDecimal("2.3"));
        System.out.println(new BigDecimal(2.3));

        BigDecimal num1 = new BigDecimal("10");
        BigDecimal num2 = new BigDecimal("3");
        //需要指定位数， 防止无限循环，或者包含在try-catch中
        BigDecimal num3 = num1.divide(num2, 3, RoundingMode.HALF_UP);
        System.out.println("num3: " + num3);
    }
}