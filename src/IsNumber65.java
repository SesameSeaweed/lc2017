public class IsNumber65 {
    public static boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        for(int i= 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                numberSeen = true;
                continue;
            }
            if(c == 'e') {
                if(eSeen) return false;
                eSeen = true;
                if(i + 1< s.length()) {
                    if(Character.isDigit(s.charAt(i+1))) continue;
                    if(s.charAt(i+1) == '+' || s.charAt(i+1) == '-') {
                        if(i + 2 < s.length()) {
                            if(Character.isDigit(s.charAt(i+2))) continue;
                        }
                    }
                }
                return false;
            }
            if(c == '.') {
                if(eSeen || pointSeen) return false;
                pointSeen = true;
                continue;
            }
            if(c == '+' || c == '-') {
                if(i + 1 < s.length()) {
                    if(Character.isDigit(s.charAt(i+1))) continue;
                }
                return false;
            }
        }
        return numberSeen;
    }

    public static void main(String[] args) {

    }
}
