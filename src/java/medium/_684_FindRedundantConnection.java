package medium;

import java.util.Arrays;

public class _684_FindRedundantConnection {
    private int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        parent = new int[m + 1];

        for (int i = 1; i < m + 1; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int px = find(edge[0]), py = find(edge[1]);
            if (px == py) {
                return edge;
            } else {
                parent[px] = py;
            }
        }
        return new int[]{-1, -1};
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        int[] ans = new _684_FindRedundantConnection().findRedundantConnection(edges);
        System.out.println(Arrays.toString(ans));
    }
}
