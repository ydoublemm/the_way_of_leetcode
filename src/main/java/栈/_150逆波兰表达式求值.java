package 栈;

import java.util.Stack;

/**
 * @Author: ymm
 * @Date: 2018/12/22 12:15
 * @Description:
 */
class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            if (tokens[i].equals("+")) {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                stack.push(num1 + num2);

            } else if (tokens[i].equals("-")) {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                stack.push(num1 - num2);

            } else if (tokens[i].equals("*")) {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                stack.push(num1 * num2);

            } else if (tokens[i].equals("/")) {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                stack.push(num1 / num2);

            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}