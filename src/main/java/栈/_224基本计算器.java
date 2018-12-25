package 栈;

import javafx.scene.layout.StackPane;
import 链表.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @Author: ymm
 * @Date: 2018/12/22 12:29
 * @Description: 还有很大优化空间
 */
class Solution224 {


    public int calculate(String s) {
        s = s.replace(" ", "");

        List<String> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        //转换成后缀表达式
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                //清空
                if(!sb.equals("")) {
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
                while (!stack.peek().equals("(")) {
                    list.add(stack.pop());
                }
                //出栈左括号
                stack.pop();
            } else {//左括号或者操作符
                //清空
                if(!sb.equals("")){
                    list.add(sb.toString());
                    sb = new StringBuilder();
                }
                char ops = s.charAt(i);
                if (ops == '(') {
                    stack.push(ops + "");
                } else {
                    while (!stack.isEmpty() && !stack.peek().equals("(") && compareOps(stack.peek(), ops + "") >= 0) {
                        list.add(stack.pop());
                    }
                    stack.push(ops + "");
                    if (stack.peek().equals("(")) {
                        stack.pop();
                    }
                }
            }
        }

        list.add(sb.toString());
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        Stack<Integer> numStack = new Stack<>();

        for (String str : list) {
            if (str.equals("")) {
                continue;
            }
            if (str.equals("+")) {
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                numStack.push(num1 + num2);
            } else if (str.equals("-")) {
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                numStack.push(num1 - num2);
            } else if (str.equals("*")) {
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                numStack.push(num1 * num2);
            } else if (str.equals("/")) {
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                numStack.push(num1 / num2);
            } else {
                numStack.push(Integer.parseInt(str));
            }
        }

        return numStack.peek();
    }

    public int compareOps(String op1, String op2) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("*", 2);
        map.put("/", 2);
        map.put("+", 1);
        map.put("-", 2);
        return map.get(op1) - map.get(op2);
    }

}


class MainClass224 {
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
            String s = stringToString(line);

            int ret = new Solution224().calculate(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}