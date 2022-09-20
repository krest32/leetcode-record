import java.time.format.TextStyle;

/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        // 普通版动态规划
        // return extracted2(n);

        // 简化动态规划
        // return extracted(n);

        // test
        return test(n);
    }

    private int test(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 00; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[i - j] * j));
            }
        }
        return dp[n];
    }

    /**
     * Your runtime beats 75.02 % of java submissions
     * Your memory usage beats 60.92 % of java submissions (37.8 MB)
     * 
     * @param n
     * @return
     */
    private int extracted2(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // 此处的思维略微比较难理解：注意 (i-j)*j -> 每个数至少能够被分为两个数字
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }

    /**
     * 
     * @param n
     * @return
     */
    private int extracted(int n) {
        // dp[i] 记录数字i的最大n个正整数和,当 n≥2 时可以拆分成至少两个正整数的和
        // dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
// @lc code=end
