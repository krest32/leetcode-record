/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // 动态规划： 背包问题
        // return extracted(strs, m, n);

        // test
        return test(strs, m, n);
    }

    private int test(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            int[] ans = getZerosOnes(strs[i]);
            int zeros = ans[0], ones = ans[1];
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 72/72 cases passed (17 ms)
     * Your runtime beats 82.08 % of java submissions
     * Your memory usage beats 73.03 % of java submissions (40.8 MB)
     * 
     * @param strs
     * @param m
     * @param n
     * @return
     */
    private int extracted(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            // 获取每个字符的中 0 和 1 的个数
            int[] zerosOnes = getZerosOnes(strs[i]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            // 此处是逆向思维，获取能够拼接成 固定字符串的自大个数
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    // dp[][] 记录 0 和 1 每个位置上最大的字符串数量
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        int len = str.length();
        for (int i = 0; i < len; i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }
}
// @lc code=end
