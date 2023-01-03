/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 暴力解法
        // return extracted2(prices);

        // 两种动态规划速度类似

        // 动态规划一
        // return extracted(prices);

        // 动态规划二
        // return extracted3(prices);

        // test
        return test(prices);

    }

    private int test(int[] prices) {
        int len = prices.length;
        int[] dp = new int[len];
        dp[0] = 0;
        int ans = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            dp[i] = Math.max(dp[i - 1] + diff, 0);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * 211/211 cases passed (4 ms)
     * Your runtime beats 25.23 % of java submissions
     * Your memory usage beats 95.32 % of java submissions (52.4 MB)
     * 
     * @param prices
     * @return
     */
    private int extracted3(int[] prices) {
        int len = prices.length;
        // 初始化 dp 数组, 记录当天卖出股票的最大利润，如果不卖出，那么当天的利润为 0
        int[] dp = new int[len];
        // 初始化 0 值
        dp[0] = 0;
        // 填充 dp 数组
        int ans = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            // 确认状态转移方程
            dp[i] = Math.max(dp[i - 1] + diff, 0);
            ans = Math.max(dp[i], ans);
        }
        return ans;

    }

    /**
     * 暴力解法 -> 超时
     * 
     * @param prices
     * @return
     */
    private int extracted2(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }

    /**
     * Your runtime beats 71.03 % of java submissions
     * Your memory usage beats 21.97 % of java submissions (57.6 MB)
     * 
     * @param prices
     * @return
     */
    private int extracted(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        // 遍历所有价格
        for (int i = 1; i < prices.length; i++) {
            // 随时获取最小值
            if (minPrice > prices[i]) {
                minPrice = prices[i];
                // 动态获取最大利润
            } else if (maxProfit < prices[i] - minPrice) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
// @lc code=end
