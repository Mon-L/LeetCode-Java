package medium;

import model.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {


    public boolean isValidBST(TreeNode root) {
        return doValidate(root, null, null);
    }

    private boolean doValidate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;


        if (!doValidate(node.left, min, node.val)) return false;
        if (!doValidate(node.right, node.val, max)) return false;

        return true;
    }

    private boolean isValidBST2(TreeNode root) {
        return dodo(root, new LinkedList<>());
    }

    private boolean dodo(TreeNode node, List<TreeNode> nodes) {
        if (node.left != null) dodo(node.left, nodes);
        if (nodes.size() > 0) {
            TreeNode tail = nodes.get(nodes.size() - 1);
            if (node.val <= tail.val) {
                return false;
            }
        }
        nodes.add(node);
        if (node.right != null) dodo(node.right, nodes);
        return true;
    }

}
