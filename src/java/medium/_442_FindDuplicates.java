package medium;

import java.util.ArrayList;
import java.util.List;

public class _442_FindDuplicates {

    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                ret.add(nums[i]);
            }
        }
        return ret;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int t = Math.abs(nums[i]);
            if (nums[t - 1] > 0) {
                nums[t - 1] = -nums[t - 1];
            } else {
                ret.add(t);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new _442_FindDuplicates().findDuplicates1(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
