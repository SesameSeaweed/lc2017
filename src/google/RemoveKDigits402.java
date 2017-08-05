package google;

public class RemoveKDigits402 {
    public static String removeKdigits(String num, int k) {
        if(k >= num.length()) return "0";
        char[] digits = num.toCharArray();
        int count = 0;
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < digits.length ; i++) {
            while(i < num.length() - 1 && digits[i] > digits[i+1] && count < k) {
                count++;
                i++;
            }
            sb.append(digits[i]);
            }

        if(count == 0 ) {
            sb = new StringBuilder(sb.substring(0, sb.length() - k));
            count = k;
        }

        if(count < k) {
            sb = new StringBuilder(removeKdigits(sb.toString(), k - count));
        }
        int j = 0;
        while (j < sb.length() && sb.charAt(j) == '0')  j++;
        return j == sb.length() ? "0" : sb.substring(j, sb.length()).toString();
    }

    public static void main(String[] args) {
        String num = "10";
        int k = 1;
        System.out.print(removeKdigits(num, k));
    }

}
