package 数据;

/**
 * @Author: ymm
 * @Date: 2018/12/29 21:30
 * @Description:
 */
class Solution268 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (1+len)*len/2;

        for (int n : nums) {
            sum -=n;
        }

        return sum;
    }
}