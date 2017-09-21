import java.util.Arrays;

public class ImplmentTrie {
    static class TrieNode {
        // Initialize your data structure here.
        char c;
        TrieNode[] child = new TrieNode[26];
        boolean isWord;
        public TrieNode() {
        }

        TrieNode(char c, TrieNode[] child, boolean isWord) {
            this.c = c;
            this.child = Arrays.copyOf(child, 26);
            this.isWord = isWord;
        }
    }

    public static class Trie {
        private static TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public static void insert(String word) {
            TrieNode curr = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.child[c-'a'] == null) {
                    curr.child[c-'a'] = new TrieNode(c, new TrieNode[26], false);
                }
                curr = curr.child[c-'a'];
                if(i == word.length() - 1) curr.isWord = true;
            }
        }

        // Returns if the word is in the trie.
        public static boolean search(String word) {
            TrieNode curr = root;

            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.child[c-'a'] == null) return false;
                curr = curr.child[c-'a'];
            }
            return curr.isWord;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public static boolean startsWith(String prefix) {
            TrieNode curr = root;

            for(int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if(curr.child[c-'a'] == null) return false;
                curr = curr.child[c-'a'];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        Trie.insert("lintcode");
        Trie.search("lint");
        System.out.println(Trie.startsWith("lint"));
    }
}
