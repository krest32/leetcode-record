/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // 原始动态方程解
        // return extracted2(obstacleGrid);

        // 动态方程优化（不推荐，理解上面存在一定难度）
        // return extracted(obstacleGrid);

        // test
        return test(obstacleGrid);

    }

    private int test(int[][] nums) {
        int m = nums.length, n = nums[0].length;
        int[][] dp = new int[m][n];
        // 初始化 0 值
        for (int i = 0; i < m; i++) {
            if (nums[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                break;
            }
        }

        // 开始获取路径
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (nums[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 40.01 % of java submissions (39.4 MB)
     * 
     * @param obstacleGrid
     * @return
     */
    private int extracted2(int[][] numss) {
        int m = nums.length, n = nums[0].length;
        int[][] dp = new int[m][n];
        // 初始化 0 值
        for (int i = 0; i < m; i++) {
            if (nums[i][0] == 0) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums[0][j] == 0) {
                dp[0][j] = 1;
            } else {
                break;
            }
        }

        // 开始获取路径
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (nums[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    private int extracted(int[][] obstacleGrid) {
        // 矩阵边界
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }
}
// @lc code=end
