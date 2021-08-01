package medium;

public class _959_RegionsBySlashes {

    private int count;
    private int[] parents;

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return;
        }

        parents[rootX] = rootY;
        count--;
    }

    public int find(int x) {
        while (x != parents[x]) {
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int size = 4 * N * N;

        this.count = size;
        this.parents = new int[size];
        for (int i = 0; i < size; i++) {
            this.parents[i] = i;
        }

        for (int i = 0; i < N; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < N; j++) {
                int index = 4 * (i * N + j);
                char c = row[j];
                // 单元格内合并
                if (c == '/') {
                    // 合并 0、3，合并 1、2
                    union(index, index + 3);
                    union(index + 1, index + 2);
                } else if (c == '\\') {
                    // 合并 0、1，合并 2、3
                    union(index, index + 1);
                    union(index + 2, index + 3);
                } else {
                    union(index, index + 1);
                    union(index + 1, index + 2);
                    union(index + 2, index + 3);
                }

                // 单元格间合并
                // 向右合并：1（当前）、3（右一列）
                if (j + 1 < N) {
                    union(index + 1, 4 * (i * N + j + 1) + 3);
                }

                // 向下合并：2（当前）、0（下一行）
                if (i + 1 < N) {
                    union(index + 2, 4 * ((i + 1) * N + j));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new _959_RegionsBySlashes().regionsBySlashes(new String[]{"/\\", "\\/"}));
    }
}
