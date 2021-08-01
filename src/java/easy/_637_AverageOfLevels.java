package easy;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _637_AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Deque<TreeNode> layer = new LinkedList<>();
        layer.add(root);

        while (!layer.isEmpty()) {
            double sum = 0;
            int size = layer.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = layer.removeFirst();
                sum += node.val;
                if (node.left != null) layer.addLast(node.left);
                if (node.right != null) layer.addLast(node.right);
            }
            ans.add(sum / size);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = root.left = new TreeNode(9);
        TreeNode node2 = root.right = new TreeNode(20);
        TreeNode node3 = node2.left = new TreeNode(15);
        TreeNode node4 = node2.right = new TreeNode(Integer.MAX_VALUE);

        System.out.println(new _637_AverageOfLevels().averageOfLevels(root));
    }
}