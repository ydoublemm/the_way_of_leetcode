package 栈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @Author: ymm
 * @Date: 2018/12/23 13:39
 * @Description:
 */
class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        Stack<Integer> stack = new Stack<>();

        for (int n : asteroids) {
            boolean flag = false;
            if (!stack.isEmpty() && stack.peek() > 0 && n < 0) {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -n) {
                    stack.pop();
                }

                if (stack.isEmpty()){
                    stack.push(n);
                } else if (!stack.isEmpty() && stack.peek() == -n) {
                    stack.pop();
                    flag = true;
                } else if (!stack.isEmpty() && stack.peek() * n > 0) {
                    stack.push(n);
                }

            } else {
                if (!flag) {
                    stack.push(n);
                }
            }

        }

        int[] res = new int[stack.size()];

        int i = 0;
        for (Integer n : stack) {
            res[i] = n;
            i++;
        }

        return res;
    }
}

class MainClass735 {
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
            int[] asteroids = stringToIntegerArray(line);

            int[] ret = new Solution735().asteroidCollision(asteroids);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}