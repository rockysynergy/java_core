package learn.javacore.String;

class RsTest {
    public static void main(String[] args) {
        String a = "/a/bc";

        String[] b = a.split("/");
        System.out.println(b[1]);
        for (String c : b) {
            System.out.println(c);
        }

    }
}