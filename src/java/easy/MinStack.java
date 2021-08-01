package easy;

import java.util.Stack;

class MinStack {
    private Stack<Integer> ele;
    private Stack<Integer> min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        ele = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        ele.push(x);
        if (min.isEmpty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        if (!ele.isEmpty()) {
            Integer top = ele.pop();
            if (top.equals(min.peek())) {
                min.pop();
            }
        }
    }

    public int top() {
        return ele.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin());   //-3
        minStack.pop();
        System.out.println(minStack.top());     //0
        System.out.println(minStack.getMin());   //-2
    }
}

