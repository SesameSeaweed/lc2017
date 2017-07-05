
public class ReverseString344 {

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.print(reverseString(s));
    }
}
