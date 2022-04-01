package medium;

import java.util.ArrayList;
import java.util.List;

public class _2049_CountHighestScoreNodes {
    private long maxScore = 0;
    private int cnt = 0;
    private int n;
    private List<Integer>[] children;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int p = parents[i];
            if (p != -1) {
                children[p].add(i);
            }
        }

        dfs(0);
        return cnt;
    }

    private int dfs(int node) {
        long score = 1;
        int num = n - 1;

        for (int c : children[node]) {
            int t = dfs(c);

            score *= t;
            num -= t;
        }

        if (node != 0) {
            score *= num;
        }

        if (maxScore == score) {
            cnt++;
        } else if (score > maxScore) {
            maxScore = score;
            cnt = 1;
        }

        return n - num;
    }

    public static void main(String[] args) {
        System.out.println(new _2049_CountHighestScoreNodes().countHighestScoreNodes(new int[]{-1}));
        System.out.println(new _2049_CountHighestScoreNodes().countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0}));
        System.out.println(new _2049_CountHighestScoreNodes().countHighestScoreNodes(new int[]{-1, 2, 0}));
    }
}
