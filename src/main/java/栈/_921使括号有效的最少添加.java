package 栈;

import java.util.Stack;

/**
 * @Author: ymm
 * @Date: 2018/12/20 12:21
 * @Description:
 */
class Solution921 {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int len = S.length();
        int count = 0;
        for(int i=0;i<len;i++){
            if (S.charAt(i) == '(') {
                stack.push('(');
            } else {//是反括号的情况
                if(stack.isEmpty()){
                    count++;
                }else if(stack.peek() == '('){
                    stack.pop();
                }
            }
        }

        return count+stack.size();
    }
}