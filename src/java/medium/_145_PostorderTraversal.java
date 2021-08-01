package medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class _145_PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        doPostOrderTraversal(root, ans);
        return ans;
    }

    private void doPostOrderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        doPostOrderTraversal(root.left, ans);
        doPostOrderTraversal(root.right, ans);
        ans.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.push(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();

            if (node.left != null) nodes.push(node.left);
            if (node.right != null) nodes.push(node.right);
            ans.addFirst(node.val);
        }
        return ans;
    }

    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode node2 = root.right = new TreeNode(2);
        TreeNode node3 = root.left = new TreeNode(3);

        System.out.println(new _145_PostorderTraversal().postorderTraversal2(root));
    }
}
