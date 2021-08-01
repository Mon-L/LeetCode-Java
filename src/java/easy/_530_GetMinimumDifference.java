package easy;

import model.TreeNode;

public class _530_GetMinimumDifference {
    private int result = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    public int getMinimumDifference(TreeNode root) {
        getMin(root);
        return result;
    }

    private void getMin(TreeNode root) {
        if (root == null) {
            return;
        }
        getMin(root.left);
        if (preNode != null) {
            result = Math.min(root.val - preNode.val, result);
        }
        preNode = root;
        getMin(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node = root.right = new TreeNode(3);
        node.left = new TreeNode(2);

        System.out.println(new _530_GetMinimumDifference().getMinimumDifference(root));
    }
}
