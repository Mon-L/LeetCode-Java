package medium;

import java.util.ArrayList;
import java.util.List;

public class _1239_MaxLength {
    private int maxLen;

    public int maxLength(List<String> arr) {
        int[] masks = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            int mask = 0;

            for (char ch : arr.get(i).toCharArray()) {
                int distance = ch - 'a';
                if (((mask >> distance) & 1) != 0) {
                    mask = 0;
                    break;

                }
                mask |= 1 << distance;
            }

            if (mask != 0) {
                masks[i] = mask;
            }
        }

        backtrack(masks, 0, 0);

        return maxLen;
    }

    public void backtrack(int[] masks, int pos, int mask) {
        if (pos == masks.length) {
            maxLen = Math.max(maxLen, Integer.bitCount(mask));
            return;
        }
        if ((mask & masks[pos]) == 0) {
            backtrack(masks, pos + 1, mask | masks[pos]);
        }
        backtrack(masks, pos + 1, mask);
    }

    public static void main(String[] args) {
        System.out.println(new _1239_MaxLength().maxLength(new ArrayList<String>() {{
            add("a");
            add("abc");
            add("d");
            add("de");
            add("def");
        }}));

        System.out.println(new _1239_MaxLength().maxLength(new ArrayList<String>() {{
            add("aa");
        }}));

        System.out.println(new _1239_MaxLength().maxLength(new ArrayList<String>() {{
            add("ab");
        }}));
    }
}
