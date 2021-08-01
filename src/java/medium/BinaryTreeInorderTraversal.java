package medium;

import model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    //-------------递归-------------
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traversal(root, list);
        return list;
    }

    private static void traversal(TreeNode node, List<Integer> list) {
        if (node == null) return;

        if (node.left != null) traversal(node.left, list);
        list.add(node.val);
        if (node.right != null) traversal(node.right, list);
    }
    //-------------递归-------------

    //-------------迭代-------------
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();

        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }

            root = deque.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
    //-------------迭代-------------

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.right = node2;
        node2.left = node3;

        System.out.println(inorderTraversal2(root));
    }

}
