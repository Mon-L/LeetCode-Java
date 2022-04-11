package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _310_FindMinHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        /*建立各个节点的出度表*/
        int[] degree = new int[n];

        /*建立图关系，在每个节点的list中存储相连节点*/
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            res = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);
                List<Integer> neighbors = map.get(cur);
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new _310_FindMinHeightTrees().findMinHeightTrees(1, new int[][]{}));
        System.out.println(new _310_FindMinHeightTrees().findMinHeightTrees(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
        System.out.println(new _310_FindMinHeightTrees().findMinHeightTrees(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
        System.out.println(new _310_FindMinHeightTrees().findMinHeightTrees(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}}));
    }
}
