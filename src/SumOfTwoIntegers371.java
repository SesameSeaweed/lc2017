public class SumOfTwoIntegers371 {
    public static int getSum(int a, int b) {
        return b == 0 ? a : getSum(a^b, (a&b) << 1);
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        System.out.print(getSum(a,b));
    }
}
