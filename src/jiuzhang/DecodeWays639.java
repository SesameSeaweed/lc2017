package jiuzhang;

public class DecodeWays639 {
//    public static int numDecodings(String s) {
//        if(s == null || s.length() == 0) return 0;
//        int n = s.length();
//        int[] dp = new int[n];
//
//        if(s.charAt(0) == '0') return 0;
//        dp[0] = (s.charAt(0) != '*') ? 1 : 9;
//
//        if(dp[1] == '*') {
//            if(dp[0] == '1') dp[1] = 9;
//            else {
//                if(dp[0] == '2') dp[1] = 6;
//                else if(dp[0] == '*') dp[1] = 97;
//            }
//        }else {
//            if(dp[0] == '1') {
//                if(dp[1] == '0') dp[1] = 1;
//                else dp[1] = 2;
//            }else {
//                if(dp[0] == '2') {
//                    if(dp[1] == '*') dp[1] = 15;
//                    if(dp[0] == '0' || dp[1] > 6) dp[1] = 1;
//                    if(dp[1] <= '6') dp[1] = 2;
//                } else dp[1] = 1;
//            }
//        }
//
//        for(int i = 2; i < n; i++) {
//            if(dp[i] == '*') {
//
//            }
//        }
//    }

    public static void main(String[] args) {

    }
}
