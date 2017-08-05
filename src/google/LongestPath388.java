package google;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestPath388 {
    public static int lengthLongestPath(String input) {
        Stack<String> stack = new Stack<>();
        String[] paths = input.split("\n");
        Pattern p = Pattern.compile("\t");
        int max = 0;
        int currentLength = 0;

        for(String path : paths) {
            Matcher m = p.matcher(path);
            int level = 1;
            while(m.find()) {
                level++;
            }
            while(stack.size() >= level) {
                String temp = stack.pop();
                currentLength -= temp.length();
            }
            String temp = path.lastIndexOf("\t") >= 0 ? path.substring(path.lastIndexOf("\t")+1, path.length()) : path;

            stack.push(temp);
            currentLength += temp.length();
            if(path.contains(".")) {
                max = Math.max(max, currentLength + level - 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        String s = "a\n\taa\n\t\taaa\n\t\t\tfile1234567890123.txt\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png";
        String s = "a.txt";
        System.out.print(lengthLongestPath(s));
    }
}
