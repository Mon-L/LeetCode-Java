package easy;

import model.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class _653_FindTarget {

    Set<Integer> map = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }

    private boolean dfs(TreeNode node, int k) {
        if (node == null) {
            return false;
        }

        if (map.contains(k - node.val)) {
            return true;
        }

        map.add(node.val);

        return dfs(node.right, k) || dfs(node.left, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);

        TreeNode node1 = root.left = new TreeNode(1);
        TreeNode node2 = root.right = new TreeNode(3);

        System.out.println(new _653_FindTarget().findTarget(root, 4));
    }
}
