package 数据;

import java.util.Arrays;

/**
 * @Author: ymm
 * @Date: 2018/12/26 12:19
 * @Description:
 */
class Solution {
    public int arrayPairSum414(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i+=2) {
            sum+=nums[i];
        }

        return sum;
    }
}