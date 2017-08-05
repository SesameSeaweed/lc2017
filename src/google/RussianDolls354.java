package google;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDolls354 {
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[envelopes.length];
        int len = 0;

        for(int i = 0; i < envelopes.length; i++) {
            int index = Arrays.binarySearch(dp, 0, len, envelopes[i][1]);
            if(index < 0) index = -(index+1);
            dp[index] = envelopes[i][1];
            if(index == len) len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5,4}, {2,3}, {6,4}, {6,7}};
        System.out.print(maxEnvelopes(envelopes));
    }
}
