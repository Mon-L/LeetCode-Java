package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 590. N叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class NaryTreePostorderTraversal {

    class Node {
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
        LinkedList list = new LinkedList();
        traversal(root, list);
        return list;
    }

    public static void traversal(Node node, List<Integer> list) {
        for (Node child : node.children) {
            traversal(child, list);
        }
        list.add(node.val);
    }

    public static void main(String[] args) {

    }
}
