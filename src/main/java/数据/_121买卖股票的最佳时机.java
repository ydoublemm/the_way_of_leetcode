package 数据;

/**
 * @Author: ymm
 * @Date: 2018/12/31 15:18
 * @Description:
 */
class Solution121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int max = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[i] < prices[j]) {
                    int tempPrice = prices[j] - prices[i];
                    if (tempPrice > max) {
                        max = tempPrice;
                    }
                }
            }
        }
        return max;
    }


    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < len; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if ((prices[i] - min) > profit) {
                profit = prices[i] - min;
            }
        }
        return profit;
    }
}