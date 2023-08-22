/*
 * @lc app=leetcode.cn id=1905 lang=java
 *
 * [1905] 统计子岛屿
 */

// @lc code=start
class Solution {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // BFS 深度优先遍历
        // return extracted(grid1, grid2);

        // test
        return test(grid1, grid2);
    }

    private int test(int[][] grid1, int[][] grid2) {
        int row = grid1.length, column = grid1[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid2[i][j] == 1 && checkArr(grid1, grid2, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean checkArr(int[][] grid1, int[][] grid2, int i, int j) {
        if (grid1[i][j] == 0) {
            return false;
        }
        grid2[i][j] = 0;
        int[][] direcs = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
        int row = grid1.length, column = grid1[0].length;
        for (int[] direc : direcs) {
            int newi = i + direc[0];
            int newj = j + direc[1];
            if (newi >= 0 && newi < row && newj >= 0 && newj < column) {
                if (grid2[newi][newj] == 1 && !check(grid1, grid2, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Your runtime beats 34.21 % of java submissions
     * Your memory usage beats 24.01 % of java submissions (72.7 MB)
     * 
     * @param grid1
     * @param grid2
     * @return
     */
    private int extracted(int[][] grid1, int[][] grid2) {
        int rows = grid2.length;
        int colums = grid2[0].length;
        int ret = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                // 如果滿足子岛屿
                if (grid2[i][j] == 1 && check(grid1, grid2, i, j)) {
                    ret++;
                }
            }
        }
        return ret;
    }

    private boolean check(int[][] grid1, int[][] grid2, int i, int j) {
        int[][] direcs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        grid2[i][j] = 0;
        int rows = grid2.length;
        int colums = grid2[0].length;
        boolean flag = true;
        if (grid1[i][j] != 1) {
            flag = false;
        }
        for (int[] direc : direcs) {
            int newi = i + direc[0];
            int newj = j + direc[1];
            if (newi >= 0
                    && newj >= 0
                    && newi < rows
                    && newj < colums
                    && grid2[newi][newj] == 1) {
                if (!check(grid1, grid2, newi, newj)) {
                    flag = false;
                }
            }
        }
        return flag;
    }
}
// @lc code=end
