import java.util.Arrays;

public class PlusOne66 {
    public static int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return new int[0];
        int[] out = new int[digits.length+1];
        int carry = 1;

        for(int i = digits.length - 1; i >= 0; i--) {
            out[i+1] = (digits[i] + carry) % 10;
            carry = (digits[i]+carry) / 10;
        }

        out[0] = carry == 1 ? 1 : 0;

        return out[0] == 1 ? out: Arrays.copyOfRange(out, 1, out.length);
    }

    public static void main(String[] args) {
        int[] digits = {9,9,9};System.out.print(Arrays.toString(plusOne(digits)));

    }
}
