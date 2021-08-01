package easy;

import java.util.*;

public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, l1 = nums1.length - 1, l2 = nums2.length - 1;


        List<Integer> list = new LinkedList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                while (i < l1 && nums1[i + 1] == nums2[j]) {
                    i++;
                }
                while (j < l2 && nums1[i] == nums2[j + 1]) {
                    j++;
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] res = new int[list.size()];
        int k = 0;
        for (Integer num : list) {
            res[k++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 8, 5}; //4 5 8 9
        int[] nums2 = new int[]{9, 4, 9, 8, 4}; //4 4 8 9 9

        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
