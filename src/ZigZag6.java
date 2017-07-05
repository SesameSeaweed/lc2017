/**
 * Created by pxu on 7/4/17.
 */
public class ZigZag6 {

    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder sb = new StringBuilder();
        int magic = numRows * 2 - 2;
        int initialdistance = magic;
        for(int i = 0; i < numRows; i++) {
            fill(sb, i, initialdistance, magic,s);
            initialdistance = initialdistance - 2;
        }
        return sb.toString();
    }

    private static  void fill(StringBuilder sb, int start, int initialdisitance, int magic, String s) {
        while (start < s.length()) {
            if(initialdisitance == 0) {
                initialdisitance = magic;
            }
            sb.append(s.charAt(start));
            start = start + initialdisitance;
            initialdisitance = magic - initialdisitance;
        }

    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s,3));
    }
}
