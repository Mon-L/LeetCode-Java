package easy;

import java.util.Arrays;

public class _455_FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int ret = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; i++, j++) {
            while (j < s.length && g[i] > s[j]) {
                j++;
            }

            if (j < s.length) {
                ret++;
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new _455_FindContentChildren().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(new _455_FindContentChildren().findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(new _455_FindContentChildren().findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}));
    }
}
