package google;

public class Pow50 {

    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == 2) return x * x;
        if(n < 0) {
            n = -n;
            x = 1/x;
        }

        if(n % 2 == 1) {
            return myPow(myPow(x,(n-1)/2),2) * x;
        }else {
            return myPow(myPow(x, n/2),2);
        }
    }

    public static void main(String[] args) {
        double x = 2;
        int n = 4;
        System.out.print(myPow(x,n));
    }

}
