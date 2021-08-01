package medium;


import java.util.*;

/**
 * 429. N叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class NaryTreeLevelOrderTraversal {

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

    //--------队列的广度遍历 start---------
    private static List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }
    //--------队列的广度遍历 end---------


    //--------优化的广度遍历 start---------
    private static List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Node> previousLayer = Collections.singletonList(root);

        while (!previousLayer.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            List<Node> nextLayer = new LinkedList<>();
            for (Node node : previousLayer) {
                level.add(node.val);
                nextLayer.addAll(node.children);
            }
            result.add(level);
            previousLayer = nextLayer;
        }
        return result;
    }
    //--------优化的广度遍历 end---------


    //--------递归 start---------
    private static List<List<Integer>> result = new ArrayList<>();

    private static List<List<Integer>> levelOrder3(Node root) {
        if (root != null) doLevelOrder3(root, 0);
        return result;
    }

    private static void doLevelOrder3(Node node, int level) {
        if (result.size() <= level) result.add(new LinkedList<>());

        result.get(level).add(node.val);
        for (Node child : node.children) {
            doLevelOrder3(child, level + 1);
        }
    }
    //--------递归 end---------

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

        System.out.println(levelOrder3(root));
    }
}
