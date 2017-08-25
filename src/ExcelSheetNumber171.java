public class ExcelSheetNumber171 {
    public static int titleToNumber(String s) {
        int out = 0;
        for(int i =0; i < s.length(); i++) {
            out = out*26+s.charAt(i)-'A'+1;
        }
        return out;
    }

    public static void main(String[] args) {
        String s = "AA";
        System.out.print(titleToNumber(s));
    }
}
