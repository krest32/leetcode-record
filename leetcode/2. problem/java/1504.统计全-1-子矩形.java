/*
 * @lc app=leetcode.cn id=1504 lang=java
 *
 * [1504] 统计全 1 子矩形
 */

// @lc code=start
class Solution {
    public int numSubmat(int[][] mat) {
        // 动态规划
        // return extracted(mat);

        return test(mat);
    }

    private int test(int[][] mat) {
        int colums = mat.length, rows = mat[0].length;
        int[][] dp = new int[colums][rows];
        // 统计每一列竖着的1举证的个数
        for (int i = 0; i < colums; i++) {
            for (int j = 0; j < rows; j++) {
                if (j == 0) {
                    dp[i][j] = mat[i][j];
                } else if (mat[i][j] == 1) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // 处理横向数据
        int ans = 0;
        for (int i = 0; i < colums; i++) {
            for (int j = 0; j < rows; j++) {
                int num = dp[i][j];
                // 统计以其作为右下角时，有多少个元素全部都是 1 的子矩形
                if (num != 0) {
                    for (int k = i; k >= 0; k--) {
                        num = Math.min(num, dp[k][j]);
                        ans += num;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 73/73 cases passed (9 ms)
     * Your runtime beats 47.24 % of java submissions
     * Your memory usage beats 39.76 % of java submissions (42.2 MB)
     * 
     * @param mat
     * @return
     */
    private int extracted(int[][] mat) {
        int colums = mat.length, rows = mat[0].length;
        int[][] dp = new int[colums][rows];
        // 统计每一列竖着的1举证的个数
        for (int i = 0; i < colums; i++) {
            for (int j = 0; j < rows; j++) {
                if (j == 0) {
                    dp[i][j] = mat[i][j];
                } else if (mat[i][j] == 1) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // 处理横向数据
        int ans = 0;
        for (int i = 0; i < colums; i++) {
            for (int j = 0; j < rows; j++) {
                int num = dp[i][j];
                // 统计以其作为右下角时，有多少个元素全部都是 1 的子矩形
                if (num != 0) {
                    for (int k = i; k >= 0; k--) {
                        num = Math.min(num, dp[k][j]);
                        ans += num;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end
