package jiuzhang;

public class DivideTwoInteger {

    public static int divide(int dividend, int divisor) {
        // write your code here

        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == 0) return 0;

        if(divisor == 1) return dividend;
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        if(divisor == -1) return -dividend;

        long val = (long) dividend * (long) divisor;
        boolean isNegatvie = val > 0 ? false : true;

        long dividendT = dividend < 0 ? -1 * (long)dividend : dividend;
        long divisorT = divisor < 0 ?-1 * (long) divisor : divisor;

        if(divisorT > dividendT) return 0;

        long out = divisorT;

        while(out * out < dividendT) {
            out++;
        }

        if(out == divisorT) {
            out = 1;
        }

        while(out * divisorT <= dividendT) {
            out++;
        }

        if(out > Integer.MAX_VALUE && !isNegatvie) return Integer.MAX_VALUE;
        if(out == Integer.MIN_VALUE*(-1) && isNegatvie) return Integer.MIN_VALUE;

        return isNegatvie ? (int) -(out-1) : (int) (out-1);
    }

    public static void main(String[] args) {
        int dividend = -1021989372;
        int divisor = -82778243;

        System.out.print(divide(dividend, divisor));
    }
}
