package 栈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @Author: ymm
 * @Date: 2018/12/23 16:26
 * @Description:
 */
class Solution456 {
    public boolean find132pattern(int[] nums) {

        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (third > nums[i]) {
                return true;
            } else {
                /*
                 * 当前元素大于栈顶元素时，就找到了132 中的 3 和 2 ，3在栈顶，2就是third，此时找到一个比third小的数就可以
                 *
                 * */
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    third = stack.pop();
                }
            }
            stack.push(nums[i]);
        }

        return false;
    }
}

class MainClass456 {
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
            int[] nums = stringToIntegerArray(line);

            boolean ret = new Solution456().find132pattern(nums);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}