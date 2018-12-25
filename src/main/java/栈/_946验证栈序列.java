package 栈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @Author: ymm
 * @Date: 2018/12/20 14:43
 * @Description:
 */
class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int len = pushed.length;
        int j = 0;
        int count = 0;
        for (int i = 0; i < len && j < len; i++) {
            int pop = popped[i];
            //这里只要遍历一次，不要再次初始化
            for (; j < len; j++) {
                if (!stack.isEmpty() && stack.peek() == pop) {
                    stack.pop();
                    count++;
                    break;
                } else if (pushed[j] == pop) {
                    count++;
                    j++;
                    break;
                } else if (pushed[j] != pop) {
                    stack.push(pushed[j]);
                }

            }
        }

        for (int i = count ; i < len; i++) {
            if(stack.pop() != popped[i]){
                return false;
            }
        }
        return true;
    }


    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int len = pushed.length;
        int j = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && popped[count] == stack.peek()) {
                stack.pop();
                count++;
            }
        }
        return stack.isEmpty();
    }
}


class MainClass946 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] pushed = stringToIntegerArray(line);
            line = in.readLine();
            int[] popped = stringToIntegerArray(line);

            boolean ret = new Solution946().validateStackSequences(pushed, popped);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}