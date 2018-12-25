package 栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author: ymm
 * @Date: 2018/12/20 12:28
 * @Description:
 */

/*
 * 这题与496的区别在于 这题栈中存的是索引，而不是元素具体的值
 *
 *
 * */
class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack();
        int len = T.length;
        for (int i = 0; i < len; i++) {
            //当前元素大于前面的元素
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int top = stack.pop();
                //没有提到的元素默认是0
                res[top] = i - top;
            }
            stack.push(i);
        }


        return res;
    }
}