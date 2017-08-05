
public class UglyNumber264 {
    public static int nthUglyNumber(int n) {
        int[] primes = {2,3,5};
        int[] index = new int[3];

        int[] out = new int[n];
        out[0] = 1;

        for(int i = 1; i < n; i++) {
            out[i] = Integer.MAX_VALUE;

            for(int j = 0; j < 3; j++) {
                out[i] = Math.min(out[i], primes[j] * out[index[j]]);
            }

            for(int j = 0; j < 3; j++) {
                if(out[i] == primes[j] * out[index[j]]) index[j]++;
            }
        }
        return out[n-1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(5));
    }
}
