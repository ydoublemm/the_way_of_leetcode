package 数据;

/**
 * @Author: ymm
 * @Date: 2018/12/29 17:22
 * @Description:
 */
class Solution27 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == val) {
                for (int j = i; j < len-1; j++) {
                    nums[j] = nums[j+1];
                }
                len--;
                i--;
            }
        }
        return len;
    }

}