public class PalindromePartition132 {
    public static int minCut(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int[] cut = new int[s.length()];
        boolean isPal[][] = new boolean[s.length()][s.length()];
        for (int i = 1; i < s.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i <= j+1 || isPal[i-1][j+1])) {
                    isPal[i][j] =true;
                    min = Math.min(min, j == 0 ? 0 : 1 + cut[j-1]);
                }
            }
            cut[i] = min;
        }
        return cut[s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));
    }
}
