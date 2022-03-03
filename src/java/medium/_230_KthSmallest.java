package medium;

import model.TreeNode;

import java.util.Stack;

public class _230_KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = root.left = new TreeNode(3);
        TreeNode node2 = root.right = new TreeNode(6);

        TreeNode node3 = node1.left = new TreeNode(2);
        TreeNode node4 = node1.right = new TreeNode(4);

        TreeNode node5 = node3.left = new TreeNode(1);

        System.out.println(new _230_KthSmallest().kthSmallest(root, 3));
    }
}
