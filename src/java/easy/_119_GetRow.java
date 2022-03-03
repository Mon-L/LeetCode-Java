package easy;

import java.util.ArrayList;
import java.util.List;

public class _119_GetRow {

    /**
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j) + pre.get(j - 1));
                }
            }
            pre = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new _119_GetRow().getRow(0));
        System.out.println(new _119_GetRow().getRow(1));
        System.out.println(new _119_GetRow().getRow(2));
        System.out.println(new _119_GetRow().getRow(3));
        System.out.println(new _119_GetRow().getRow(4));
        System.out.println(new _119_GetRow().getRow(5));
    }
}
