package medium;

public class _307_NumArray {

    static class NumArray {

        private int[] nums;
        private int[] trees;

        public NumArray(int[] nums) {
            this.nums = nums;
            this.trees = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }

        public void update(int index, int val) {
            add(index + 1, val - this.nums[index]);
            this.nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return prefixSum(right + 1) - prefixSum(left);
        }

        private int lowBit(int x) {
            return x & -x;
        }

        private void add(int index, int val) {
            while (index < trees.length) {
                trees[index] += val;
                index += lowBit(index);
            }
        }

        private int prefixSum(int index) {
            int sum = 0;
            while (index > 0) {
                sum += trees[index];
                index -= lowBit(index);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(numArray.sumRange(4, 4));
        System.out.println(numArray.sumRange(2, 4));
    }
}
