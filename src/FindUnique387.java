public class FindUnique387 {
    public static int firstUniqChar(String s) {
        int[] index = new int[26];
        int out = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) index[i] = Integer.MAX_VALUE-1;
        for(int i = 0; i < s.length(); i++) {
            int in = s.charAt(i) - 'a';
            if(index[in] == Integer.MAX_VALUE-1) index[in] = i;
            else index[in] = Integer.MAX_VALUE;

        }
        for(int i = 0; i < 26; i++) {
            out = Math.min(index[i], out);
        }
        return out >= Integer.MAX_VALUE-1 ? -1 : out;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.print(firstUniqChar(s));
    }
}
