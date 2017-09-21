import java.util.Arrays;

public class AddOrSearchWord211 {
    private static class TrieNode {
        char c;
        TrieNode[] child = new TrieNode[27];
        boolean isWord = false;
        public TrieNode(){

        }

        TrieNode(char c, TrieNode[] child, boolean isWord) {
            this.c = c;
            this.child = Arrays.copyOf(child, 26);
            this.isWord = isWord;
        }
    }

    private static TrieNode root = new TrieNode('*', new TrieNode[27], false);

    /** Initialize your data structure here. */
    public AddOrSearchWord211() {
    }

    /** Adds a word into the data structure. */
    public static void addWord(String word) {
        char[] charArrays = word.toCharArray();
        TrieNode curr = root;

        for (int i = 0; i < charArrays.length; i++) {
            char c = charArrays[i];
            if(curr.child[c-'a'] == null) {
                curr.child[c - 'a'] = new TrieNode(c, new TrieNode[26], false);
            }
            curr = curr.child[c - 'a'];
            if (i == charArrays.length - 1) {
                curr.isWord = true;
            }
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public static boolean search(String word) {
        TrieNode curr = root;
        
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(TrieNode kid : curr.child) {
                    if(kid != null) {
                        char[] temp = word.toCharArray();
                        temp[i] = kid.c;
                        String newWord = String.valueOf(temp);
                        if(search(newWord)) return true;
                    }
                }
                return false;
            }
            if(curr.child[c-'a'] != null) {
                curr = curr.child[c-'a'];
            } else return false;
            if(i == word.length() - 1 && !curr.isWord) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        addWord("bad");
//        addWord("dad");
//        addWord("mad");
//
//        System.out.println(search("pad"));
//        System.out.println(search("bad"));
//        System.out.println(search(".ad"));
//        System.out.println(search("b.."));

        addWord("a");
        addWord("ab");
        System.out.println(search("a"));
        System.out.println(search("a."));
        System.out.println(search("ab"));
        System.out.println(search(".a"));
        System.out.println(search(".b"));
        System.out.println(search("ab."));
        System.out.println(search("."));
        System.out.println(search(".."));

//        addWord("at");
//        addWord("and");
//        addWord("an");
//        addWord("add");
//        System.out.println(search("a"));
//        System.out.println(search(".at"));
//        addWord("bat");
//        System.out.println(search(".at"));
//        System.out.println(search("an."));
//        System.out.println(search(".a.d."));
//        System.out.println(search("b."));

    }
}
