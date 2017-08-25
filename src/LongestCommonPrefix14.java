public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder("");

        int length = Integer.MAX_VALUE;
        for(String str : strs) {
            length = Math.min(length, str.length());
        }

        for(int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for(String str : strs) {
                if(str.charAt(i) != c) return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
