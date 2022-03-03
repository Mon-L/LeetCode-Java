package easy;

public class _169_MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0, candidate = 0;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }

            count += (candidate == n ? 1 : -1);
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new _169_MajorityElement().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new _169_MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
