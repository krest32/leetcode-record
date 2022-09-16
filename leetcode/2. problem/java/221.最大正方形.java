
/**
 * @lc app=leetcode.cn id=221 lang=java
 *
 *     [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        } else {
            int rows = matrix.length;
            int colums = matrix[0].length;
            // 定义 dp 数据
            int[][] dp = new int[rows][colums];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < colums; j++) {
                    if (matrix[i][j] == '1') {
                        // 初始化 0 值
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            // 状态转移方程
                            dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        }
                        maxSide = Math.max(maxSide, dp[i][j]);
                    }
                }
            }
            return maxSide * maxSide;
        }
    }
}
// @lc code=end
