import java.util.Arrays;

/**
 * @lc app=leetcode.cn id=322 lang=java
 *
 *     [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 动态规划
        // return extracted(coins, amount);

        // test
        return test(coins, amount);
    }

    private int test(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    /**
     * 189/189 cases passed (12 ms)
     * Your runtime beats 70.21 % of java submissions
     * Your memory usage beats 90.82 % of java submissions (40.8 MB)
     * 
     * @param coins
     * @param amount
     * @return
     */
    private int extracted(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i < max; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    // 从i中减掉对应的金额，获取相应的硬币数量，并加1
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
// @lc code=end
