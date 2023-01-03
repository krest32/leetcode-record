/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        // 动态规划
        // return extracted(k, prices);

        // test
        return test(k, prices);
    }

    private int test(int k, int[] prices) {
        int len = prices.length;
        // 0 表示卖出， 1 表示持有
        int[][][] dp = new int[len][k + 1][2];
        if (len == 0) {
            return 0;
        }
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }

    /**
     * 210/210 cases passed (7 ms)
     * Your runtime beats 32.06 % of java submissions
     * Your memory usage beats 22.32 % of java submissions (41.8 MB)
     * 
     * @param k
     * @param prices
     * @return
     */
    private int extracted(int k, int[] prices) {
        if (prices.length == 0)
            return 0;

        // [天数][交易次数][是否持有股票]
        int len = prices.length;
        int[][][] dp = new int[len][k + 1][2];

        // dp数组初始化
        // 初始化所有的交易次数是为确保 最后结果是最多 k 次买卖的最大利润
        // 0代表卖出，1代表买入
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                // dp方程, 0表示不持有/卖出, 1表示持有/买入
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }
}
// @lc code=end
