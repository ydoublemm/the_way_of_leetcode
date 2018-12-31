package 数据;

/**
 * @Author: ymm
 * @Date: 2018/12/29 17:29
 * @Description:
 */
class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        if (len == 0) { return 0; }

        int maxlen = 0;
        int currlen = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                currlen++;
            } else {
                if (currlen > maxlen) {
                    maxlen = currlen;
                }
                currlen = 0;
            }
        }
        if (currlen > maxlen) {
            maxlen = currlen;
        }

        return maxlen;
    }
}