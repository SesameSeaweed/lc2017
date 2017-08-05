package google;

public class PowerOfTwo231 {
    public static boolean isPowerOfTwo(int n) {
        while(n > 1) {
            if(n % 2 == 0) n/=2;
            else return false;
        }
        return n == 1 ? true : (n == 0 ? true : false);
    }

    public static void main(String[] args) {
        System.out.print(isPowerOfTwo(3));
    }
}
