import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 */

// @lc code=start
class Solution {
    public int lastStoneWeightII(int[] stones) {
        // 背包问题
        // return extracted(stones);

        // test
        return test(stones);
    }

    private int test(int[] stones) {
        int len = stones.length;
        int sum = Arrays.stream(stones).sum();
        int half = sum / 2;
        int[][] dp = new int[len + 1][half + 1];

        for (int i = 1; i <= len; i++) {
            int curVal = stones[i - 1];
            for (int j = 1; j <= half; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= curVal) {
                    // 塞满当前的背包
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - curVal] + curVal);
                }
            }
        }

        return Math.abs(sum - dp[len][half] * 2);
    }

    private int extracted(int[] stones) {
        int n = stones.length;
        int sum = Arrays.stream(stones).sum();
        int halfSum = sum / 2;
        int[][] dp = new int[n + 1][halfSum + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= halfSum; j++) {
                // 默认背包 == 上一个背包的最大值
                dp[i][j] = dp[i - 1][j];
                int cur = stones[i - 1];
                // 更新背包中的最大值
                if (j >= cur) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cur] + cur);
                }
            }
        }
        return Math.abs(sum - dp[n][halfSum] * 2);
    }
}
// @lc code=end
