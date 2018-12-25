package 栈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @Author: ymm
 * @Date: 2018/12/19 15:07
 * @Description:
 */
class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = GetBackSpaceString(S);
        Stack<Character> stack2 = GetBackSpaceString(T);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if(stack1.pop() != stack2.pop()){
                return false;
            }
        }
        if(stack1.isEmpty() && stack2.isEmpty())
            return true;
        return false;
    }

    public Stack<Character> GetBackSpaceString(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for(int i=0; i< len;i++){
            if(!stack.empty() && s.charAt(i) == '#'){
                stack.pop();
            } else if (stack.empty() && s.charAt(i) == '#') {

            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack;
    }

}


 class MainClass844{
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String S = stringToString(line);
            line = in.readLine();
            String T = stringToString(line);

            boolean ret = new Solution844().backspaceCompare(S, T);

            String out = booleanToString(ret);

            System.out.print(out);
        }

    }
}