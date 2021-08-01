package medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _113_PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new LinkedList<>(), root, sum);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, Deque<Integer> curr, TreeNode root, int sum) {
        if (root == null) return;

        curr.offerLast(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(curr));
        }
        dfs(ans, curr, root.left, sum);
        dfs(ans, curr, root.right, sum);
        curr.pollLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode node1 = root.left = new TreeNode(4);
        TreeNode node2 = root.right = new TreeNode(8);

        TreeNode node3 = node1.left = new TreeNode(11);


        TreeNode node4 = node2.left = new TreeNode(13);
        TreeNode node5 = node2.right = new TreeNode(4);

        TreeNode node6 = node3.left = new TreeNode(7);
        TreeNode node7 = node3.right = new TreeNode(2);

        node5.left = new TreeNode(5);
        node5.right = new TreeNode(1);

        System.out.println(new _113_PathSum().pathSum(root, 22));
    }
}
