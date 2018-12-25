package 栈;

import java.util.Stack;

/**
 * @Author: ymm
 * @Date: 2018/12/19 14:06
 * @Description:
 */
class Solution682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops){
            if("C".equals(op)){
                stack.pop();
            } else if ("D".equals(op)) {
                stack.push(stack.peek()*2);
            }else if ("+".equals(op)){
                int top = stack.pop();
                int preTop = stack.peek();
                stack.push(top);
                stack.push(top+preTop);
            }else {
                stack.push(Integer.parseInt(op));
            }
        }

        int count  = 0;
        for (Integer score : stack){
            count+=score;
        }

        return count;
    }
}
