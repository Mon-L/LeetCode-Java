package hard;

public class _765_MinSwapsCouples {

    public int minSwapsCouples(int[] row) {
        int[] mapping = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            mapping[row[i]] = i;
        }

        int ret = 0;
        for (int i = 0; i < row.length - 1; i = i + 2) {
            int couple = row[i] ^ 1;

            if (row[i + 1] != couple) {
                int index = mapping[couple];

                swap(mapping, row[i + 1], row[index]);
                swap(row, index, i + 1);

                ret++;
            }
        }

        return ret;
    }

    private void swap(int[] row, int x, int y) {
        int temp = row[x];
        row[x] = row[y];
        row[y] = temp;
    }

    public static void main(String[] args) {
        int[] row;
        row = new int[]{0, 2, 1, 3}; // 1
        System.out.println(new _765_MinSwapsCouples().minSwapsCouples(row));

        row = new int[]{3, 2, 0, 1}; // 0
        System.out.println(new _765_MinSwapsCouples().minSwapsCouples(row));

        row = new int[]{5, 3, 4, 2, 1, 0}; // 1
        System.out.println(new _765_MinSwapsCouples().minSwapsCouples(row));

        row = new int[]{2, 0, 5, 4, 3, 1}; // 1
        System.out.println(new _765_MinSwapsCouples().minSwapsCouples(row));

        row = new int[]{0, 2, 4, 6, 7, 1, 3, 5}; // 3
        System.out.println(new _765_MinSwapsCouples().minSwapsCouples(row));
    }

}
