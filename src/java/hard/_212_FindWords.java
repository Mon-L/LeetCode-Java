package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/word-search-ii
 */
public class _212_FindWords {

    private int m;
    private int n;
    private TrieNode root;
    private char[][] board;
    private List<String> ans;
    private boolean[][] visited;

    private class TrieNode {
        private String word;
        private TrieNode[] links;

        private TrieNode() {
            this.links = new TrieNode[26];
        }

        private void put(String word) {
            TrieNode node = root;
            for (int i = 0, len = word.length(); i < len; i++) {
                char ch = word.charAt(i);

                if (node.links[ch - 'a'] == null) {
                    node.links[ch - 'a'] = new TrieNode();
                }
                node = node.links[ch - 'a'];
            }
            node.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        this.root = new TrieNode();
        this.visited = new boolean[m][n];
        this.ans = new ArrayList<>();

        for (String word : words) {
            root.put(word);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, root);
            }
        }

        return ans;
    }

    private void dfs(int x, int y, TrieNode node) {
        if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) {
            return;
        }

        char ch = board[x][y];
        if (node.links[ch - 'a'] == null) {
            return;
        }
        node = node.links[ch - 'a'];

        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }

        visited[x][y] = true;
        dfs(x + 1, y, node);
        dfs(x, y + 1, node);
        dfs(x - 1, y, node);
        dfs(x, y - 1, node);
        visited[x][y] = false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        System.out.println(new _212_FindWords().findWords(board, words));
    }
}
