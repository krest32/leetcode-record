/*
 * @lc app=leetcode.cn id=1901 lang=java
 *
 * [1901] 寻找峰值 II
 */

// @lc code=start
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        // 暴力
        return extracted(mat);
    }

    /**
     * Your runtime beats 16.76 % of java submissions
     * Your memory usage beats 66.19 % of java submissions (77.9 MB)
     * 
     * @param mat
     * @return
     */
    private int[] extracted(int[][] mat) {
        int rows = mat.length;
        int colums = mat[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (check(mat, i, j)) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[0];
    }

    private boolean check(int[][] mat, int i, int j) {
        int rows = mat.length;
        int colums = mat[0].length;
        int cur = mat[i][j];
        if ((i + 1 < rows && mat[i + 1][j] >= cur)
                || (i - 1 >= 0 && mat[i - 1][j] >= cur)
                || (j + 1 < colums && mat[i][j + 1] >= cur)
                || (j - 1 >= 0 && mat[i][j - 1] >= cur)) {
            return false;

        }
        return true;
    }
}
// @lc code=end
