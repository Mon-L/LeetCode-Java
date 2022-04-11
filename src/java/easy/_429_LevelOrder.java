package easy;

import model.NaryNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _429_LevelOrder {

    public List<List<Integer>> levelOrder(NaryNode root) {
        List<List<Integer>> ret = new ArrayList<>();

        Queue<NaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NaryNode node = queue.poll();
                level.add(node.val);

                if (node.children != null) {
                    for (NaryNode n : node.children) {
                        queue.add(n);
                    }
                }
            }
            ret.add(level);
        }

        return ret;
    }
}
