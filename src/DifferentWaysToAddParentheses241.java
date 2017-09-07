import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses241 {
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> out = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if(Character.isDigit(c)) continue;
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()));

            for(int num1 : left) {
                for(int num2 : right) {
                    out.add(helper(num1, num2, input.charAt(i)));
                }
            }
        }
        if(out.size() == 0) {
            out.add(Integer.valueOf(input));
        }
        return out;
    }

    private static int helper(int num1, int num2, char operator) {
        switch (operator) {
        case '+' : return num1 + num2;
        case '-' : return num1 - num2;
        case '*' : return num1 * num2;
        case '/' : return num1 / num2;
        }
        return 0;
    }

    public static void main(String[] args) {
        String input = "2*3-4*5";
        List<Integer> out = diffWaysToCompute(input);
        System.out.println(out);
    }
}
