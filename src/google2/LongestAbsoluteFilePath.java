package google2;

import java.util.HashMap;
import java.util.Map;

public class LongestAbsoluteFilePath {
    public static int lengthLongestPath(String input) {

        // "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
        Map<Integer, Integer> map = new HashMap<>();
        int level = 0;
        String[] subs = input.split("\n");
        int max = 0;
        StringBuilder sb = new StringBuilder("");
        sb.append(subs[0]);
        map.put(0,0);

       for(String s : subs) {
           level = s.lastIndexOf("\t") + 1;
           if(map.containsKey(level)) {
               map.put(level+1, map.get(level) + s.substring(s.lastIndexOf("\t")+1).length() + 1);
           }
           if(s.contains(".")) {
               max = Math.max(map.get(level+1)-1, max);
           }
       }
        return max;
    }

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\t\tfile1\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2";
        System.out.print(lengthLongestPath(input));
    }
}
