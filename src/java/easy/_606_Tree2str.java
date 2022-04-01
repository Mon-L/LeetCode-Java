package easy;

import model.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入: 二叉树: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * 输出: "1(2(4))(3)"
 */
public class _606_Tree2str {

    public String tree2str_bfs(TreeNode root) {
        Deque<Object[]> stack = new LinkedList<>();
        stack.push(new Object[]{0, root});

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            Object[] obj = stack.peek();
            int loc = (Integer) obj[0];
            TreeNode node = (TreeNode) obj[1];

            if (loc == 1) {
                ans.append(")");
                stack.pop();
            } else {
                obj[0] = 1;
                ans.append("(").append(node.val);

                if (node.right != null) {
                    stack.push(new Object[]{0, node.right});
                }

                if (node.left != null) {
                    stack.push(new Object[]{0, node.left});
                } else if (node.right != null) {
                    ans.append("()");
                }
            }
        }

        return ans.substring(1, ans.length() - 1);
    }

    public String tree2str(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        dfs(ans, root);
        return ans.substring(1, ans.length() - 1);
    }

    private void dfs(StringBuilder ans, TreeNode node) {
        if (node == null) {
            return;
        }

        ans.append("(").append(node.val);
        dfs(ans, node.left);

        if (node.left == null && node.right != null) {
            ans.append("()");
        }

        dfs(ans, node.right);
        ans.append(")");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode node1 = root.left = new TreeNode(2);
        TreeNode node2 = root.right = new TreeNode(3);

        node1.left = new TreeNode(4);

        System.out.println(new _606_Tree2str().tree2str_bfs(root));
    }
}
