package medium;

import java.util.ArrayList;
import java.util.List;

public class _1823_FindTheWinner {

    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int count = 0, pos = 0;
        while (list.size() != 1) {
            if (pos == list.size()) {
                pos = 0;
            }

            if (++count == k) {
                list.remove(pos);
                count = 0;
                continue;
            }
            pos++;
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new _1823_FindTheWinner().findTheWinner(5, 2));
        System.out.println(new _1823_FindTheWinner().findTheWinner(6, 5));
    }
}
