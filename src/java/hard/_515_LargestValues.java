package hard;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _515_LargestValues {

    //------BFS-------//
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new LinkedList<>();

        if (root == null) return ans;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();

            int max = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode curr = deque.pollFirst();

                if (curr.val > max) {
                    max = curr.val;
                }

                if (curr.left != null) deque.add(curr.left);
                if (curr.right != null) deque.add(curr.right);
            }
            ans.add(max);
        }
        return ans;
    }
    //------BFS-------//


    //------DFS-------//
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans, 0);
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> ans, int level) {
        if (node == null) return;

        if (level == ans.size()) {
            ans.add(Integer.MIN_VALUE);
        }

        if (ans.get(level) < node.val) {
            ans.set(level, node.val);
        }

        dfs(node.left, ans, level + 1);
        dfs(node.right, ans, level + 1);
    }
    //------DFS-------//

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = root.left = new TreeNode(3);
        TreeNode node2 = root.right = new TreeNode(2);
        TreeNode node3 = node1.left = new TreeNode(5);
        TreeNode node4 = node1.right = new TreeNode(3);
        TreeNode node5 = node2.right = new TreeNode(9);

        System.out.println(new _515_LargestValues().largestValues2(root));
    }
}
