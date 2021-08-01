package easy;

import model.TreeNode;

public class _538_ConvertBST {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val = sum += root.val;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        new _538_ConvertBST().convertBST(root);
    }
}
