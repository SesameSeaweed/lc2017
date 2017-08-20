public class DivideTwoIntegers29 {
    public static int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;

        boolean isNeg = false;

        long dividendInput = dividend;
        long divisorInput = divisor;
        if(dividend < 0) {
            isNeg = true;
            dividendInput = (long) dividend * (-1);
        }
        if(divisor < 0) {
            isNeg = !isNeg;
            divisorInput = (long) divisor * (-1);
        }

       long out = count(dividendInput, divisorInput);
        if(out > Integer.MAX_VALUE || out < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return isNeg ? (int) out*(-1) :(int) out;
    }

    private static long count(long dividend, long divisor) {
        long out = 1;
        long sum = divisor;
        if(dividend < divisor) return 0;
        if(dividend == divisor) return 1;
        while(dividend > sum) {
            sum += sum;
            out *= 2;
        }
        return out/2 + count(dividend -  sum/2, divisor);
    }

    public static void main(String[] args) {
        int dividend = Integer.MIN_VALUE;
        int divisor = 2;
        System.out.print(divide(dividend, divisor));
    }
}
