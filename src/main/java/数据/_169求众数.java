package 数据;

/**
 * @Author: ymm
 * @Date: 2018/12/27 14:56
 * @Description:
 */
class Solution169 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int count = 0;
        int major = Integer.MIN_VALUE;
        for (int n : nums) {
            if (count == 0) {
                major = n;
                count++;
            } else {
                if (major == n) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return major;
    }
}