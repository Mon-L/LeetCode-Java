package medium;

import model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {

    //---------------递归---------------
    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traversal(root, list);
        return list;
    }

    private static void traversal(TreeNode node, List<Integer> list) {
        if (node == null) return;

        list.add(node.val);
        if (node.left != null) traversal(node.left, list);
        if (node.right != null) traversal(node.right, list);
    }
    //---------------递归---------------

    //----------------迭代--------------
    private static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop();
            ans.add(node.val);
            if (node.right != null) deque.push(node.right);
            if (node.left != null) deque.push(node.left);
        }
        return ans;
    }
    //----------------迭代--------------

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.right = node2;
        node2.left = node3;

        System.out.println(preorderTraversal2(root));
    }

}
