package google;
import java.util.Arrays;

public class PlusOne66 {
    public static int[] plusOne(int[] digits) {
        int carry = 1;
        int[] out = new int[digits.length+1];
        for(int i = digits.length; i >= 1; i--) {
            out[i] = (digits[i - 1] + carry) % 10;
            carry = (digits[i - 1]  + carry) / 10;
        }
        if(carry == 0) return Arrays.copyOfRange(out, 1, out.length);
        out[0] = 1;

        return out;
    }

    public static void main(String[] args) {
        int[] digits = {9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
