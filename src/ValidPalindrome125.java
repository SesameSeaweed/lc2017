public class ValidPalindrome125 {
    public static boolean isPalindrome(String s) {
        String sLower = s.toLowerCase();
        for (int i = 0, j = sLower.length() - 1; i < s.length() && i < j && j >= 0; i++, j--) {
            while (i <= j && !isAlphaNumberic(sLower.charAt(i))) {
                i++;
            }
            while (i <= j && !isAlphaNumberic(sLower.charAt(j))) {
                j--;
            }
            if (i <= j) {
                if (sLower.charAt(i) != sLower.charAt(j))
                    return false;
            }
        }
        return true;
    }

    private static boolean isAlphaNumberic(char c) {
        if(c >= 'a' && c <= 'z') return true;
        if(c >= '0' && c <= '9') return true;
        return false;
    }
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
//        String s ="0P";
        System.out.print(isPalindrome(s));
    }
}
