/*
 * @lc app=leetcode.cn id=840 lang=java
 *
 * [840] 矩阵中的幻方
 */

// @lc code=start
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        // BFS
        // return extracted(grid);

        // test
        return test(grid);

    }

    private int test(int[][] grid) {
        int row = grid.length, column = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < column - 2; j++) {
                if (grid[i + 1][j + 1] != 5) {
                    continue;
                }
                if (check(grid[i][j], grid[i][j + 1], grid[i][j + 2],
                        grid[i + 1][j], grid[i + 1][j + 1], grid[i + 1][j + 2],
                        grid[i + 2][j], grid[i + 2][j + 1], grid[i + 2][j + 2])) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean check(int... vals) {
        int[] count = new int[16];
        for (int v : vals) {
            count[v]++;
        }
        // 统计每个数字的出现频率，此处应该从1开始
        for (int i = 1; i <= 9; i++) {
            if (count[i] != 1) {
                return false;
            }
        }
        return (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);
    }

    /**
     * 93/93 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 91.86 % of java submissions (39 MB)
     * 
     * @param grid
     * @return
     */
    private int extracted(int[][] grid) {
        int rows = grid.length, colums = grid[0].length;
        int ans = 0;
        for (int r = 0; r < rows - 2; ++r)
            for (int c = 0; c < colums - 2; ++c) {
                // 中心需要是5，才能成为合理矩阵
                if (grid[r + 1][c + 1] != 5)
                    continue; // optional skip
                if (magic(grid[r][c], grid[r][c + 1], grid[r][c + 2],
                        grid[r + 1][c], grid[r + 1][c + 1], grid[r + 1][c + 2],
                        grid[r + 2][c], grid[r + 2][c + 1], grid[r + 2][c + 2]))
                    ans++;
            }

        return ans;
    }

    public boolean magic(int... vals) {
        // 统计每个数字的出现频率
        int[] count = new int[16];
        for (int v : vals)
            count[v]++;
        // 判断9个数字中，不能由重复的数字
        for (int v = 1; v <= 9; ++v)
            if (count[v] != 1)
                return false;

        return (vals[0] + vals[1] + vals[2] == 15 &&
                vals[3] + vals[4] + vals[5] == 15 &&
                vals[6] + vals[7] + vals[8] == 15 &&
                vals[0] + vals[3] + vals[6] == 15 &&
                vals[1] + vals[4] + vals[7] == 15 &&
                vals[2] + vals[5] + vals[8] == 15 &&
                vals[0] + vals[4] + vals[8] == 15 &&
                vals[2] + vals[4] + vals[6] == 15);
    }
}
// @lc code=end
