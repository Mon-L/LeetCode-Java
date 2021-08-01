package medium;

public class _1584_MinCostConnectPoints_2 {

    /**
     * prim 算法
     *
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        int N = points.length, ret = 0;

        //记录该节点是否加入树中
        boolean[] v = new boolean[N];
        v[0] = true;

        //记录树与其他节点的最小距离
        int[] dist = new int[N];
        for (int i = 1; i < N; i++) {
            dist[i] = findDist(points, 0, i);
        }

        for (int i = 1; i < N; i++) {
            //查找离树最近的节点
            int next = -1;
            for (int j = 0; j < N; j++) {
                if (v[j]) continue;
                if (next == -1 || dist[next] > dist[j]) next = j;
            }

            ret += dist[next];
            v[next] = true;

            for (int j = 0; j < N; j++) {
                if (!v[j]) {
                    //更新树与其他节点的最小距离
                    dist[j] = Math.min(dist[j], findDist(points, j, next));
                }
            }
        }

        return ret;
    }

    private int findDist(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{
                {0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}
        };
        System.out.println(new _1584_MinCostConnectPoints_2().minCostConnectPoints(points));

        points = new int[][]{
                {3, 12}, {-2, 5}, {-4, 1}
        };
        System.out.println(new _1584_MinCostConnectPoints_2().minCostConnectPoints(points));

        points = new int[][]{
                {-1000000, -1000000}, {1000000, 1000000}
        };
        System.out.println(new _1584_MinCostConnectPoints_2().minCostConnectPoints(points));

        points = new int[][]{
                {0, 0}
        };
        System.out.println(new _1584_MinCostConnectPoints_2().minCostConnectPoints(points));

    }
}
