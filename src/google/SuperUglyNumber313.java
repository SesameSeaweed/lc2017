package google;

public class SuperUglyNumber313 {

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] out = new int[n];
        int[] indexes = new int[primes.length];
        out[0] = 1;

        for(int i = 1; i < n; i++) {
                out[i] = Integer.MAX_VALUE;

            for(int j = 0; j < primes.length; j++) {
                out[i] = Math.min(out[i], primes[j] * out[indexes[j]]);
            }

            for(int j=0; j < primes.length; j++) {
                if(primes[j] * out[indexes[j]] == out[i]) indexes[j]++;
            }
        }
        return out[n-1];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] primes = {2,7, 13,19};
        System.out.println(nthSuperUglyNumber(n, primes));
    }
}
