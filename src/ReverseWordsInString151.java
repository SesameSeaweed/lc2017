import java.util.Stack;

/**
 * Created by pxu on 7/5/17.
 */
public class ReverseWordsInString151 {

    public static String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String[] arrays = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arrays.length; i++) {
            String remp = arrays[i];
            int j = 0;
            while(j < remp.length() && remp.charAt(j) == ' ') {
                j++;
            }
            if(j == remp.length()) continue;
            stack.push(remp.substring(j, remp.length()));
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        return sb.length() == 0 ? sb.toString() : sb.substring(0, sb.length() - 1).toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
//        String s = "a    b";
        System.out.print(reverseWords(s));
    }
}
