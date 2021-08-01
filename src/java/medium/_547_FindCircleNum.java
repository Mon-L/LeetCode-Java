package medium;

public class _547_FindCircleNum {

    private int count;
    private int[] parent;

    public int findCircleNum(int[][] M) {
        int m = M.length;

        count = m;
        parent = new int[m];

        for (int i = 0; i < m; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int num = M[i][j];
                if (num == 1) {
                    union(i, j);
                }
            }
        }
        return count;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if (p1 != p2) {
            parent[p1] = p2;
            count--;
        }
    }

    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(new _547_FindCircleNum().findCircleNum(M));

        M = new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        System.out.println(new _547_FindCircleNum().findCircleNum(M));
    }
}
