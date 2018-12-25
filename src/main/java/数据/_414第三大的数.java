package 数据;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author: ymm
 * @Date: 2018/12/25 15:30
 * @Description:
 */
class Solution414 {
    public int thirdMax(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        } else {
            int first, second, third;
            first = Integer.MIN_VALUE;
            second = Integer.MIN_VALUE;
            third = Integer.MIN_VALUE;

            boolean flag = false;
            for (int i = 0; i < len; i++) {

                if (nums[i] == Integer.MIN_VALUE) {
                    flag = true;
                }
                if (nums[i] == first || nums[i] == second || nums[i] == third) {
                    continue;
                }
                if (nums[i] > first) {
                    third = second;
                    second = first;
                    first = nums[i];
                } else if (nums[i] > second) {
                    third = second;
                    second = nums[i];
                } else if (nums[i] > third) {
                    third = nums[i];
                }
            }

            if ((flag == false && third == Integer.MIN_VALUE) || (second == third)) {
                return first;
            }else {
                return third;
            }
        }
    }
}


 class MainClass414 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new Solution414().thirdMax(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}