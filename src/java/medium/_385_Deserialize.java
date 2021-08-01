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

    //"[123,[456,[789]]]"
    public NestedInteger deserialize(String s) {
        Deque<NestedInteger> deque = new LinkedList<>();
        char[] chars = s.toCharArray();

        if (chars.length == 0) return new NestedInteger();
        if (chars[0] != '[') return new NestedInteger(Integer.parseInt(s));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '-' || (ch >= 48 && ch <= 57)) {
                sb.append(ch);
            } else if (ch == ',') {
                if (sb.length() != 0) {
                    Integer num = Integer.parseInt(sb.toString());
                    sb.delete(0, sb.length());

                    deque.peek().add(new NestedInteger(num));
                }
            } else if (ch == '[') {
                deque.push(new NestedInteger());
            } else if (ch == ']') {
                if (sb.length() != 0) {
                    Integer num = Integer.parseInt(sb.toString());
                    sb.delete(0, sb.length());
                    deque.peek().add(new NestedInteger(num));
                }

                if (deque.size() > 1) {
                    NestedInteger ni = deque.poll();
                    deque.peek().add(ni);
                }
            }
        }
        return deque.poll();
    }
}
