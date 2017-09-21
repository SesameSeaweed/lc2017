package jiuzhang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordSearchII {
    private static class TrieNode {
        char label;
        TrieNode[] child = new TrieNode[26];
        boolean isWord;

        TrieNode() {
            this.child = new TrieNode[26];
            this.isWord = false;
        }

        TrieNode(char label, TrieNode[] child, boolean isWord) {
            this.label = label;
            this.child = Arrays.copyOf(child, 26);
            this.isWord = isWord;
        }
    }

    public static List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.size() == 0) return new ArrayList<>();

        TrieNode root = new TrieNode();
        TrieNode curr = root;
        HashSet<String> out = new HashSet<>();

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for(String word : words) {
            curr = root;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(curr.child[c-'a'] == null) {
                    TrieNode newTemp = new TrieNode(c, new TrieNode[26], false);
                    curr.child[c-'a'] = newTemp;
                }
                curr = curr.child[c-'a'];
                if(i == word.length() - 1) curr.isWord = true;

            }
        }

        curr = root;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(curr.child[board[i][j] - 'a'] != null) {
                    visited[i][j] = true;
                    StringBuilder sb = new StringBuilder("");
                    sb.append(board[i][j]);
                    dfs(board, m, n, i, j, curr.child[board[i][j] - 'a'], visited, sb, out);
                }
            }
        }
        return new ArrayList<>(out);
    }

    private static void dfs(char[][] board, int m, int n, int i, int j, TrieNode root, boolean[][] visited, StringBuilder sb, HashSet<String> out) {
        TrieNode curr = root;
        if (root.isWord) {
            out.add(sb.toString());
        }

        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x < 0 || y < 0 || x >= m || y >= n || curr.child[board[x][y] - 'a'] == null || visited[x][y])
                continue;
            char t = board[x][y];
            sb.append(t);
            visited[x][y] = true;
            dfs(board, m, n, x, y, curr.child[t - 'a'], visited, sb, out);
            sb.deleteCharAt(sb.length()-1);
            visited[x][y] = false;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'d','o','a','f'},
                {'a','g','a','i'},
                {'d', 'c', 'a', 'n'}
        };
//        "dog", "dad", "dgdg", "can", "again",
        List<String> words = Arrays.asList( "dogo");
        List<String> out = wordSearchII(board, words);
        System.out.println(out);
    }

}
