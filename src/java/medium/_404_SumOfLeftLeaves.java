package medium;

import model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class _404_SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }

        if (isLeft && node.left == null && node.right == null) {
            return node.val;
        }
        return dfs(node.left, true) + dfs(node.right, false);
    }

    private int bfs(TreeNode root) {
        int count = 0;
        if (root == null) return count;

        Deque<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            TreeNode curr = list.poll();

            if (curr.left != null) {
                if (curr.left.left == null && curr.left.right == null) {
                    count += curr.left.val;
                }
                list.push(curr.left);
            }

            if (curr.right != null) {
                list.push(curr.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        TreeNode node2 = root.right = new TreeNode(20);

        node2.left = new TreeNode(15);
        node2.right = new TreeNode(7);

        System.out.println(new _404_SumOfLeftLeaves().sumOfLeftLeaves(root));
    }
}
