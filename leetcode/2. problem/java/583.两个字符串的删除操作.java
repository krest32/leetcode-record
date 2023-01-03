/*
 * @lc app=leetcode.cn id=583 lang=java
 *
 * [583] 两个字符串的删除操作
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        // return extracted(word1, word2);

        // test
        return test(word1, word2);
    }

    private int test(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return len1 + len2 - 2 * dp[len1][len2];
    }

    /**
     * 1306/1306 cases passed (5 ms)
     * Your runtime beats 94.34 % of java submissions
     * Your memory usage beats 70.86 % of java submissions (41.9 MB)
     * 
     * @param word1
     * @param word2
     * @return
     */
    private int extracted(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 代表两个字符串的最长公共子序列
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int lcs = dp[m][n];
        // 然后总长度减去公共序列长度
        return m + n - 2 * lcs;
    }
}
// @lc code=end
