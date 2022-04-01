package easy;

import model.NaryNode;

import java.util.*;

public class _589_Preorder {

    public List<Integer> preorder(NaryNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, ret);
        return ret;
    }

    private void dfs(NaryNode node, List<Integer> vals) {
        if (node == null) {
            return;
        }

        vals.add(node.val);

        for (NaryNode c : node.children) {
            dfs(c, vals);
        }
    }

    public List<Integer> preorder_bfs(NaryNode root) {
        if(root == null) return Collections.emptyList();

        List<Integer> ret = new ArrayList<>();

        Deque<NaryNode> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            NaryNode node = stack.pop();
            ret.add(node.val);

            if(node.children != null) {
                List<NaryNode> children = node.children;
                for (int i = children.size() - 1; i >= 0; i--) {
                    stack.push(children.get(i));
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        NaryNode root = new NaryNode(1);

        NaryNode n1 = new NaryNode(3);
        NaryNode n2 = new NaryNode(2);
        NaryNode n3 = new NaryNode(4);

        root.children.add(n1);
        root.children.add(n2);
        root.children.add(n3);

        NaryNode n4 = new NaryNode(5);
        NaryNode n5 = new NaryNode(6);

        n1.children.add(n4);
        n1.children.add(n5);

        System.out.println(new _589_Preorder().preorder_bfs(root));
    }

}
