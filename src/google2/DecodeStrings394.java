package google2;
public class DecodeStrings394 {
    public static String decodeString(String s) {
        StringBuilder out = new StringBuilder("");
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                count = Character.getNumericValue(s.charAt(i)) + count * 10;
            } else {
                if(s.charAt(i) == '[') {
                    int pair = 1;
                    StringBuilder tmp = new StringBuilder("");
                    while(++i < s.length() && pair != 0) {
                        if(s.charAt(i) == '[') pair++;
                        if(s.charAt(i) == ']') pair--;
                        tmp.append(s.charAt(i));
                    }
                    i--;
                    String decodeInside = decodeString(tmp.substring(0, tmp.length()-1).toString());
                    while(count-- > 0) {
                        out.append(decodeInside);
                    }
                    count++;
                } else {
                    out.append(s.charAt(i));
                }
            }
        }
        return out.toString();
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        System.out.print(decodeString(s));
    }
}
