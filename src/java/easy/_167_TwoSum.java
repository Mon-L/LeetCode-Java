package easy;

import java.util.Arrays;

public class _167_TwoSum {

    //二分查找
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    //双指针
    public int[] twoSum2(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int a = numbers[left], b = numbers[right];

            if (a + b == target) {
                break;
            } else if (a + b < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{left + 1, right + 1};
    }

    //双指针+二分查找
    public int[] twoSum3(int[] numbers, int target) {
        int pl = 0, pr = numbers.length - 1, pm;
        while (pl <= pr) {
            pm = pl + (pr - pl) / 2;
            
            int low = numbers[pl], high = numbers[pr], mid = numbers[pm];

            if (low + mid > target) {
                pr = pm - 1;
            } else if (high + mid < target) {
                pl = pm + 1;
            } else if (low + high > target) {
                pr--;
            } else if (low + high < target) {
                pl++;
            } else {
                return new int[]{pl + 1, pr + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] ans = new _167_TwoSum().twoSum3(new int[]{1, 2, 3, 4, 4, 9, 56, 90}, 8);
        System.out.println(Arrays.toString(ans));
    }
}
