package easy;

public class _720_LongestWord {

    public String longestWord(String[] words) {
        Tire root = new Tire();
        for (String w : words) {
            root.insert(w);
        }

        return root.findLongest();
    }

    private static class Tire {
        String word;
        String ret = "";
        Tire[] children = new Tire[26];
        int maxDeep = 0;

        private void insert(String word) {
            Tire curr = this;
            for (char c : word.toCharArray()) {
                Tire child = new Tire();
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = child;
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
        }

        private String findLongest() {
            dfs(this, 0);
            return ret;
        }

        private void dfs(Tire node, int deep) {
            if (deep > maxDeep) {
                ret = node.word;
                maxDeep = deep;
            }

            for (Tire n : node.children) {
                if (n != null && n.word != null) {
                    dfs(n, deep + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _720_LongestWord().longestWord(new String[]{"w"}));
        System.out.println(new _720_LongestWord().longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
        System.out.println(new _720_LongestWord().longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }

}
