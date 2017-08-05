package google;

public class IntegerReplacement397 {
    public static int integerReplacement(int n) {
       int count = 0;

        while(n != 1) {
            if((n & 1) == 0) {
                n = (n >>> 1);
            }else {
                if(n == 3 || Integer.bitCount(n+1) > Integer.bitCount(n-1)) {
                    n--;
                }else {
                    n++;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(integerReplacement(7));
    }
}
