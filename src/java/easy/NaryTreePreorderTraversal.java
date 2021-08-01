package easy;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class NaryTreePreorderTraversal {

    private static class Node {
        int val;
        List<Node> children;


        Node(int _val) {
            val = _val;
            children = new LinkedList<>();
        }

        void addChild(Node node) {
            children.add(node);
        }

    }

    public static List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        ArrayDeque<Node> deque = new ArrayDeque<>();

        if (root == null) return list;

        deque.push(root);
        while (deque.size() > 0) {
            Node curr = deque.pop();
            list.add(curr.val);

            for (int i = curr.children.size() - 1; i >= 0; i--) {
                deque.push(curr.children.get(i));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);

        root.addChild(node3);
        root.addChild(node2);
        root.addChild(node4);

        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node3.addChild(node5);
        node3.addChild(node6);

        System.out.println(preorder(root));
    }
}
