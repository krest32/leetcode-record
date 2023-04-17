/*
 * @lc app=leetcode.cn id=1277 lang=java
 *
 * [1277] 统计全为 1 的正方形子矩阵
 */

// @lc code=start
class Solution {
    public int countSquares(int[][] matrix) {
        // 动态规划
        // return extracted1(matrix);

        // 动态规划 2
        return extracted2(matrix);

    }

    private int extracted2(int[][] matrix) {
        int column = matrix.length, rows = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[column][rows];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < rows; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }

                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }

    /**
     * 32/32 cases passed (6 ms)
     * Your runtime beats 71.36 % of java submissions
     * Your memory usage beats 37.23 % of java submissions (50.4 MB)
     * 
     * @param matrix
     * @return
     */
    private int extracted1(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int ans = 0;
        // i, j 作为正方形的右下角, dp记录边长大于1的正方形
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                        ans++;
                        continue;
                    }
                    // 如果matrix[i][j] == 1，则此处最小有一个正方形
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),
                            dp[i - 1][j - 1]) + 1;
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }
}
// @lc code=end
