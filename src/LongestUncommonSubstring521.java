public class LongestUncommonSubstring521 {
    public static int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());

    }
    public static void main(String[] args) {
        String s = "aba";
        String t= "cdc";
        System.out.print(findLUSlength(s,t));
    }
}
