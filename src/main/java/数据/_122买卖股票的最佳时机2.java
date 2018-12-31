package 数据;

/**
 * @Author: ymm
 * @Date: 2018/12/29 17:45
 * @Description:
 */
class Solution122 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int len = prices.length;

        if(len==0 || len ==1) return 0;
        int pre = prices[0];

        for (int i = 1; i < len; i++) {
            if (prices[i] > pre) {
                sum += prices[i] - pre;
            }
            pre = prices[i];
        }
        return sum;
    }
}