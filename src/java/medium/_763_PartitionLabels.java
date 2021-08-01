package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 */
public class _763_PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();

        int[] mapping = new int[26];
        for (int i = 0; i < S.length(); i++) {
            mapping[S.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, mapping[S.charAt(i) - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _763_PartitionLabels().partitionLabels("e"));
        System.out.println(new _763_PartitionLabels().partitionLabels("eaaaabaaec"));
        System.out.println(new _763_PartitionLabels().partitionLabels("caedbdedda"));
        System.out.println(new _763_PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
