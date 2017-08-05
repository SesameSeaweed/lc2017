package google;

public class RepeatSubstring459 {
    public static boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() == 1) return false;

        int length = s.length();

        for(int i = 2; i <= length; i++) {
            StringBuilder sb = new StringBuilder();
            if(length % i == 0) {
                int j = i;
                while(j > 0) {
                    sb.append(s.substring(0, length / i));
                    j--;
                }
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "bb";
        System.out.print(repeatedSubstringPattern(s));
    }
}
