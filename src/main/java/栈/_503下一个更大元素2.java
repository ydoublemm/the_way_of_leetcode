package 栈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: ymm
 * @Date: 2018/12/21 16:14
 * @Description:
 */
class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] doubleNums = new int[len * 2];
        //复制一份新的数组
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < len; j++) {
                doubleNums[len * i + j] = nums[j];
            }
        }

        for (int i = 0; i < len * 2; i++) {
            while (!stack.isEmpty() && doubleNums[i] > doubleNums[stack.peek()]) {
                map.put(stack.pop(), doubleNums[i]);
            }
            stack.push(i);
        }

        for (int i = 0; i < len; i++) {
            if (map.containsKey(i)) {
                res[i] = map.get(i);
            } else {
                res[i] = -1;
            }
        }

        return res;

    }
}

class MainClass503 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int[] ret = new Solution503().nextGreaterElements(nums);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}