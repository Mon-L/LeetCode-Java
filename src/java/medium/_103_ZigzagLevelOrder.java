package medium;

import model.TreeNode;

import java.util.*;

public class _103_ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if ((level & 1) == 1) Collections.reverse(list);
            result.add(list);
            level++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode node2 = root.left = new TreeNode(9);
        TreeNode node3 = root.right = new TreeNode(20);

        node2.left = new TreeNode(8);
        node3.left = new TreeNode(15);
        node3.right = new TreeNode(7);

        List<List<Integer>> ans = new _103_ZigzagLevelOrder().zigzagLevelOrder(root);
        System.out.println(ans);
    }
}
