package easy;

import java.util.*;

/**
 * 590. N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class _590_NaryTreePostorderTraversal {

    private final class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }

    private void dfs(Node node, List<Integer> ret) {
        if (node == null) {
            return;
        }

        for (Node n : node.children) {
            dfs(n, ret);
        }
        ret.add(node.val);
    }

    public List<Integer> postorder2(Node root) {
        if (root == null) return Collections.emptyList();

        Deque<Integer> ret = new LinkedList<>();
        Deque<Node> list = new LinkedList<>();
        list.add(root);

        while (!list.isEmpty()) {
            Node node = list.pop();
            if (node.children != null) {
                for (int i = 0; i < node.children.size(); i++) {
                    list.push(node.children.get(i));
                }
            }

            ret.addFirst(node.val);
        }

        return new ArrayList<>(ret);
    }

}
