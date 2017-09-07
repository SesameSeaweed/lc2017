import java.util.ArrayList;
import java.util.List;

public class RestoreIP93 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> out = new ArrayList<>();
        int len = s.length();

        for(int i = 0; i < 4 && i < len - 2; i++) {
            for(int j = i+1; j < i+4 && j < len - 1; j++) {
                for(int t = j+1; t < j+4 && t < len; t++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i,j);
                    String s3 = s.substring(j, t);
                    String s4 = s.substring(t, s.length());
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        StringBuilder temp = new StringBuilder(s1);
                        temp.append(".").append(s2).append(".").append(s3).append(".").append(s4);
                        out.add(temp.toString());
                    }
                }
            }
        }
        return out;
    }

    private static boolean isValid(String s) {
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> out = restoreIpAddresses(s);
        System.out.print(out);
    }
}
