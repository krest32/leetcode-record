/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 动态规划
        // return extracted(prices);

        // test
        return test(prices);
    }

    private int test(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][4];
        // 初始化数据， 0,2 代表当天买入之后的利润
        dp[0][0] = -prices[0];
        dp[0][2] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] + prices[i]);
        }
        return dp[len - 1][3];
    }

    /**
     * 214/214 cases passed (20 ms)
     * Your runtime beats 43.57 % of java submissions
     * Your memory usage beats 89.42 % of java submissions (51.9 MB)
     * 
     * @param prices
     * @return
     */
    private int extracted(int[] prices) {
        int len = prices.length;
        if (len == 0)
            return 0;
        /*
         * 定义 4 种状态:
         * 1: 第一次买入,
         * 2: 第一次卖出,
         * 3: 第二次买入,
         * 4: 第二次卖出
         */
        // dp 记录某梯田的
        int[][] dp = new int[len][5];
        // 初始化 0 值
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i][3] + prices[i]);
        }

        return dp[len - 1][4];
    }
}
// @lc code=end
