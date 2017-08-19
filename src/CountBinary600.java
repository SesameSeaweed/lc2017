public class CountBinary600 {
    public static int findIntegers(int num) {
        StringBuilder s = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = s.length();
        int[] a = new int[n+1];
        int[] b = new int[n+1];

        a[0] = 1;
        b[0] = 1;

        for(int i = 1; i <= n; i++) {
            a[i] = a[i-1]+b[i-1];
            b[i] = a[i-1];
        }

        for(int i = n - 2; i >= 0; i--) {
            if(s.charAt(i) == '0' && s.charAt(i+1) == '0') a[n] -= b[i];
            if(s.charAt(i) == '1' && s.charAt(i+1) == '1') break;
        }
        return a[n];
    }

    public static void main(String[] args) {
        System.out.println(findIntegers(5));
    }
}
