package google2;

public class RepeatedSubstring459 {
    public static boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        for(int i = 2; i <= length; i++) {
            if(length % i == 0) {
                String sub = s.substring(0, length/i);
                if(substringPattern(s, sub)) return true;
            }
        }
        return false;
    }
    private static boolean substringPattern(String s, String sub) {
        int count = 0;
        if(sub.length() == 0) return false;
        if(s.length() % sub.length() == 0) {
            count = s.length() / sub.length();
        } else return false;
        StringBuilder sb = new StringBuilder(sub);
        while(count > 1) {
            sb.append(sub);
            count--;
        }
        if(sb.toString().equals(s)) return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "bb";
        System.out.print(repeatedSubstringPattern(s));
    }
}
