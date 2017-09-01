import java.util.Arrays;

public class PairLength646 {
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, ((a,b)->(a[0]-b[0])));
        int m = pairs.length;
        int[] dp = new int[m+1];
        int out = 0;

        for(int i = 1; i <= m; i++) {
            int index = findX(pairs, i-1);
            if(index == -1) dp[i] = Math.max(dp[i-1],1);
            else dp[i] = Math.max(dp[i-1], dp[index+1] + 1);
            out = Math.max(out, dp[i]);
        }
        return out;
    }

    private static int findX(int[][] pairs, int index) {
        for(int i = index - 1; i >= 0; i--) {
            if(pairs[i][1] < pairs[index][0]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1,2}, {2,3}, {3,3},{4,5}};
        System.out.print(findLongestChain(pairs));
    }


}
