import java.util.Arrays;

public class CountBits338 {
    public static int[] countBits(int num) {
        int[] out = new int[num+1];
        int pow = 1;

        for(int i = 1; i <= num; i++) {
            if(i == pow) {
                pow *= 2;
            }
            out[i] = out[i-pow/2]+1;
        }
        return out;
    }

    public static void main(String[] args) {
        int num = 16;
        System.out.print(Arrays.toString(countBits(num)));
    }
}
