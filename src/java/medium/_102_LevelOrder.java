package medium;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _102_LevelOrder {

    //-------------bfs-------------//
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            int size = list.size();

            List<Integer> layer = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode curr = list.pollFirst();
                layer.add(curr.val);

                if (curr.left != null) list.add(curr.left);
                if (curr.right != null) list.add(curr.right);
            }
            ans.add(layer);
        }
        return ans;
    }
    //-------------bfs-------------//

    //-------------dfs-------------//
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            dfs(res, root, 0);
        }
        return res;
    }

    private void dfs(List<List<Integer>> ans, TreeNode node, int level) {
        if (level > ans.size() - 1) {
            ans.add(new ArrayList<>());
        }

        ans.get(level).add(node.val);
        if (node.left != null) dfs(ans, node.left, level + 1);
        if (node.right != null) dfs(ans, node.right, level + 1);
    }
    //-------------dfs-------------//

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        TreeNode node2 = new TreeNode(9);
        root.left = node2;

        TreeNode node3 = new TreeNode(20);
        node2.right = node3;

        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node3.left = node4;
        node3.right = node5;

        System.out.println(new _102_LevelOrder().levelOrder2(root));
    }
}
