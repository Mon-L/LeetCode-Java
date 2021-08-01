package medium;

import model.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _117_Connect {

    public Node connect(Node root) {
        return null;
    }

    private Node bfs(Node root) {
        if (root == null) return null;

        Queue<Node> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            Node pre = null;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node curr = deque.poll();
                if (pre != null) {
                    pre.next = curr;
                }
                pre = curr;

                if (pre.left != null) deque.offer(pre.left);
                if (pre.right != null) deque.offer(pre.right);
            }
        }
        return root;
    }

    private List<Node> pres = new LinkedList<>();

    private void dfs(Node root, int level) {
        if (pres.size() == level) {
            pres.add(root);
        } else {
            pres.get(level).next = root;
            pres.set(level, root);
        }

        if (root.left != null) dfs(root.left, level + 1);
        if (root.right != null) dfs(root.right, level + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        Node node2 = root.left = new Node(2);
        Node node3 = root.right = new Node(3);

        Node node4 = node2.left = new Node(4);
        Node node5 = node2.right = new Node(5);

        Node node7 = node3.right = new Node(7);

        new _117_Connect().connect(root);
    }
}
