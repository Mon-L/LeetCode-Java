package easy;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _501_FindMode {

    private int curr_count = 0;
    private int max_count = 0;
    private int pre = -1;
    private final List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        doFind(root);

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private void doFind(TreeNode root) {
        if (root != null) {
            doFind(root.left);

            curr_count = root.val == pre ? curr_count + 1 : 1;
            pre = root.val;

            if (curr_count > max_count) {
                list.clear();
                list.add(root.val);
                max_count = curr_count;
            } else if (curr_count == max_count) {
                list.add(root.val);
            }

            doFind(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);

        TreeNode node1 = root.left = new TreeNode(1);
        TreeNode node2 = root.right = new TreeNode(3);
        TreeNode node3 = node2.left = new TreeNode(3);

        int[] ans = new _501_FindMode().findMode(root);

        System.out.println(Arrays.toString(ans));
    }
}
