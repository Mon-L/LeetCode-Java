package medium;

import model.NestedInteger;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 s = "324",
 * 你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
 * <p>
 * 给定 s = "[123,[456,[789]]]",
 * 返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
 * 1. 一个 integer 包含值 123
 * 2. 一个包含两个元素的嵌套列表：
 * i.  一个 integer 包含值 456
 * ii. 一个包含一个元素的嵌套列表
 * <p>
 * 385. 迷你语法分析器
 * https://leetcode-cn.com/problems/mini-parser/
 */
public class _385_Deserialize {

    //"[123]"
    //[123,[456,[789]]]
    public NestedInteger deserialize(String s) {
        if (s.length() == 0) return new NestedInteger();
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));

        Deque<NestedInteger> deque = new LinkedList<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            if (s.charAt(r) == '[') {
                deque.push(new NestedInteger());
                l++;
            } else if (s.charAt(r) == ']') {
                if (l != r) {
                    int num = Integer.parseInt(s.substring(l, r));
                    deque.peek().add(new NestedInteger(num));
                    l = r;
                }

                if (deque.size() > 1) {
                    NestedInteger ni = deque.poll();
                    deque.peek().add(ni);
                }

                l++;
            } else if (s.charAt(r) == ',') {
                if (l != r) {
                    int num = Integer.parseInt(s.substring(l, r));
                    deque.peek().add(new NestedInteger(num));
                    l = r;
                }
                l++;
            }
        }

        return deque.poll();
    }

    public static void main(String[] args) {
        // NestedInteger ret1 = new _385_Deserialize().deserialize("[123]");
        NestedInteger ret2 = new _385_Deserialize().deserialize("[123,[456],789]");
        System.out.println(new Object());
    }
}
