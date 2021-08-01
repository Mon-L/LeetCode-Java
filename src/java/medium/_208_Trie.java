package medium;

class _208_Trie {

    private final TrieNode root;

    public _208_Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0, len = word.length(); i < len; i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch);
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0, len = word.length(); i < len; i++) {
            char curLetter = word.charAt(i);
            if (!node.containsKey(curLetter)) {
                return null;
            }
            node = node.get(curLetter);
        }
        return node;
    }

    private static class TrieNode {
        private final TrieNode[] links;

        private boolean isEnd;

        private TrieNode() {
            this.links = new TrieNode[26];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch) {
            links[ch - 'a'] = new TrieNode();
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}