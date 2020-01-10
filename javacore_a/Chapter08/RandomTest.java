import java.util.Random;

/**
 * RandomTest
 */
public class RandomTest {

    public static void main(String[] args) {
        // Method 1: Use Random
        Random rd = new Random();
        System.out.println(rd.nextInt());
        System.out.println(rd.nextInt(100));
        System.out.println(rd.nextLong());
        System.out.println(rd.nextDouble());
        System.out.println("==================================");

        // Method 2: use Math.random
        System.out.println(Math.round(Math.random()*10));
        System.out.println("==================================");

        // JDK new method 
        rd.ints(); // Return unlimited random numbers (int) 
        int[] arr = rd.ints(10).toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("===============================");

        arr = rd.ints(5, 10, 100).toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("==================================");

        arr = rd.ints(10).limit(5).toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}