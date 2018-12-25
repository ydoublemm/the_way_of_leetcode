package 栈;

import java.util.Stack;

/**
 * @Author: ymm
 * @Date: 2018/12/21 14:20
 * @Description:
 */
class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();


    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || x <= min.peek()){
            min.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return ;
        }
        Integer pop = stack.pop();
        if(!min.isEmpty() && pop.equals(min.peek()))
            min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}