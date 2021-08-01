package medium;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class _106_BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) return null;

        Map<Integer, Integer> inorderMapping = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMapping.put(inorder[i], i);
        }

        return build(inorderMapping, 0, inorder.length - 1, postorder.length - 1, postorder);
    }

    private TreeNode build(Map<Integer, Integer> inorderMapping, int inStart, int inEnd, int postEnd, int[] postorder) {
        if (inStart > inEnd) {
            return null;
        }

        int root = postorder[postEnd];
        int mid = inorderMapping.get(root);

        TreeNode node = new TreeNode(root);
        node.left = build(inorderMapping, inStart, mid - 1, postEnd - (inEnd - mid) - 1, postorder);
        node.right = build(inorderMapping, mid + 1, inEnd, postEnd - 1, postorder);
        return node;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        System.out.println(new _106_BuildTree().buildTree(inorder, postorder));
    }
}
