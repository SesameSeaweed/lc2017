package jiuzhang;

public class DecodeWays91 {
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;

        int n = s.length();
        int[] dp = new int[n];

        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        if(dp[0] == 0) return 0;

        if(n == 1) return 1;

        dp[1] = 1;
        int m = Integer.parseInt(s.substring(0, 2));
        if(m <= 26 && m >= 10 && s.charAt(1) != '0') {
            dp[1] = 2;
        } else {
            dp[1] = 0;
        }

        for(int i = 2; i < n; i++) {
            int temp = Integer.parseInt(s.substring(i-1, i+1));
            if(s.charAt(i) == '0') {
                if(temp > 26 || temp < 10) return 0;
                dp[i] = dp[i-2];
                continue;
            }
            if(temp <= 26 && temp >=10 ) dp[i] = dp[i - 1] + dp[i -2];
            else dp[i] = dp[i-1];
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        String s = "301";
        System.out.println(numDecodings(s));
    }
}
