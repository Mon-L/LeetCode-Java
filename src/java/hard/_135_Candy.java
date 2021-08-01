package hard;

public class _135_Candy {

    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        for (int i = 0; i < len; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int[] right = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (i < len - 1 && ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int ret = 0;
        for (int i = 0; i < len; i++) {
            ret += Math.max(left[i], right[i]);
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new _135_Candy().candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
        System.out.println(new _135_Candy().candy(new int[]{1, 0}));
        System.out.println(new _135_Candy().candy(new int[]{1, 0, 2}));
        System.out.println(new _135_Candy().candy(new int[]{1, 2, 2}));
    }
}
