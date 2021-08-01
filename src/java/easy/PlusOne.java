package easy;

import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        for(int i = digits.length - 1 ; i >= 0; i--){
            digits[i]++;
            if(digits[i] % 10 != 0){
                return digits;
            }
            digits[i] = 0;
            if(i == 0){
                int[] r = new int[digits.length + 1];
                r[0] = 1;
                return r;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1};
        System.out.println(Arrays.toString(plusOne(nums)));

        nums = new int[]{1, 0, 9};
        System.out.println(Arrays.toString(plusOne(nums)));

        nums = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }

}
