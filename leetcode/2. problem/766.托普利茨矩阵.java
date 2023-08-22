/*
 * @lc app=leetcode.cn id=766 lang=java
 *
 * [766] 托普利茨矩阵
 */

// @lc code=start
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // 遍历
        // return extracted(matrix);

        // test
        return test(matrix);
    }

    private boolean test(int[][] matrix) {
        int row = matrix.length, column = matrix[0].length;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 对角先遍历
     * 
     * @param matrix
     * @return
     */
    private boolean extracted(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 不能 从0开始比对，因为可能会导致数据的下标越界
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
