import java.math.BigInteger;

public class BigIntegerTest {

    public static void main(String[] args) {
        BigInteger b1 = new BigInteger("123456789");
        BigInteger b2 = new BigInteger("987654321");

        System.out.println("b1: " + b1 + ", b2: " + b2);
        System.out.println("Add: " + b2.add(b1));
        System.out.println("Sub: " + b2.subtract(b1));
        System.out.println("multiply: " + b2.multiply(b1));
        System.out.println("divide: " + b2.divide(b1));
        System.out.println("max:" + b2.max(b1));
        System.out.println("min: " + b2.min(b1));
        BigInteger result[] = b2.divideAndRemainder(b1);
        System.out.println("quotient: " + result[0] + "; remainder: " + result[1]);
        System.out.println("equals: " + b1.equals(b2));
        int flag = b1.compareTo(b2);
        if (flag == -1) 
            System.out.println("compare: b1 < b2");
        else if (flag == 0)
            System.out.println("comapre: b1 == b2");    
        else 
            System.out.println("compare: b1> b2");
    }

}