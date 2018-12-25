package 栈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @Author: ymm
 * @Date: 2018/12/21 15:41
 * @Description:
 */
class Solution {
    public int scoreOfParentheses(String S) {
        Stack<String> stack = new Stack<>();
        int len = S.length();

        int score = 0;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == '(') {
                stack.push("(");
            }else {//是')'的情况
                //前一个是'(' 正好匹配
                if (stack.peek().equals("(")) {
                    stack.pop();
                    stack.push("1");
                }else {
                    int temp = 0;
                    while (!stack.isEmpty() && !stack.peek().equals("(")){
                        temp+= Integer.parseInt(stack.pop());
                    }
                    temp *=2;
                    stack.pop();
                    stack.push(temp+"");
                }
            }
        }

        while (!stack.isEmpty()) {
            score += Integer.parseInt(stack.pop());
        }
        return score;
    }
}

class MainClass856 {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String S = stringToString(line);

            int ret = new Solution().scoreOfParentheses(S);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}