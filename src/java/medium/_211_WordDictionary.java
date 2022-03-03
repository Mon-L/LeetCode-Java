package medium;

public class _211_WordDictionary {

    private static class WordDictionary {

        private Trie trie = new Trie();

        public WordDictionary() {

        }

        public void addWord(String word) {
            trie.add(word);
        }

        public boolean search(String word) {
            return trie.search(word);
        }
    }

    private static class Trie {
        private final Trie[] children = new Trie[26];
        private boolean idEnd;

        public void add(String word) {
            Trie cur = this;

            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';

                Trie node = cur.children[pos];
                if (node == null) {
                    node = new Trie();
                    cur.children[pos] = node;
                }
                cur = node;
            }

            cur.idEnd = true;
        }

        public boolean search(String word) {
            return doSearch(word, 0, this);
        }

        private boolean doSearch(String word, int pos, Trie cur) {
            if (cur == null) {
                return false;
            }

            if (pos == word.length()) {
                return cur.idEnd;
            }

            char ch = word.charAt(pos);
            if (ch == '.') {
                boolean flag = false;
                for (int i = 0; i < 26 && !flag; i++) {
                    flag = doSearch(word, pos + 1, cur.children[i]);
                }

                return flag;
            }
            return doSearch(word, pos + 1, cur.children[ch - 'a']);
        }
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");

        System.out.println(wd.search("bad"));
        System.out.println(wd.search("dad"));
        System.out.println(wd.search("mad"));
        System.out.println(wd.search("bac"));
        System.out.println(wd.search("..."));
    }
}
