package easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class _821_ShortestToChar {

    public int[] shortestToChar(String s, char c) {
        int[] ret = new int[s.length()];
        Arrays.fill(ret, -1);

        Queue<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                deque.add(i);
                ret[i] = 0;
            }
        }

        int[] dir = new int[]{-1, 1};
        while (!deque.isEmpty()) {
            int curr = deque.poll();
            for (int d : dir) {
                int next = curr + d;
                if (next >= 0 && next < s.length() && ret[next] == -1) {
                    ret[next] = ret[curr] + 1;
                    deque.add(next);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _821_ShortestToChar().shortestToChar("loveleetcode", 'e')));
        System.out.println(Arrays.toString(new _821_ShortestToChar().shortestToChar("aaab", 'b')));
    }
}
