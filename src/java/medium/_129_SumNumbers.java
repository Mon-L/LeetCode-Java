package medium;

import model.TreeNode;

public class _129_SumNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }

        int sum = prev * 10 + root.val;

        if (root.left == null && root.right == null) {
            return sum;
        }

        return dfs(root.left, sum) + dfs(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        TreeNode node1 = root.left = new TreeNode(9);
        root.right = new TreeNode(0);

        node1.left = new TreeNode(5);
        node1.right = new TreeNode(1);

        System.out.println(new _129_SumNumbers().sumNumbers(root));
    }
}
