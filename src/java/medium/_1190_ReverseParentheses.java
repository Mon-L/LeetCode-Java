package medium;

import java.util.Deque;
import java.util.LinkedList;

public class _1190_ReverseParentheses {

    /**
     * s = "(abcd)"
     *
     * @param s
     * @return
     */
    public static String reverseParentheses(String s) {
        Deque<Character> in = new LinkedList<>();
        Deque<Character> out = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                Character curr = in.poll();
                while (curr != null && curr != '(') {
                    out.add(curr);
                    curr = in.poll();
                }

                while (!out.isEmpty()) {
                    in.push(out.poll());
                }
            } else {
                in.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!in.isEmpty()) {
            sb.append(in.removeLast());
        }
        return sb.toString();
    }


    public static String reverseParentheses2(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuffer sb = new StringBuffer();
        int index = 0, step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(_1190_ReverseParentheses.reverseParentheses2("(u(love)i)"));
//        System.out.println(_1190_ReverseParentheses.reverseParentheses2("(ed(et(oc))el)"));
//        System.out.println(_1190_ReverseParentheses.reverseParentheses2("a(bcdefghijkl(mno)p)q"));
    }
}
