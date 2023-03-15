
/**
 * @lc app=leetcode.cn id=79 lang=java
 *
 *     [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        // 图 DFS 算法
        // return extracted(board, word);

        // test
        return test(board, word);
    }

    private boolean test(char[][] board, String word) {
        int row = board.length, column = board[0].length;
        boolean[][] vis = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (checkTest(board, word, vis, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkTest(char[][] board, String word, boolean[][] vis, int i, int j, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        } else {
            int row = board.length;
            int colums = board[0].length;
            vis[i][j] = true;
            int[][] dirc = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
            for (int[] dir : dirc) {
                int newi = dir[0] + i;
                int newj = dir[1] + j;
                if (newi >= 0 && newj < row && newj >= 0 && newj < colums && !vis[newi][newj]) {
                    if (check(board, word, vis, newi, newj, k + 1)) {
                        return true;
                    }
                }
            }
            vis[i][j] = false;
            return false;

        }
    }

    private boolean extracted(char[][] board, String word) {
        int width = board.length;
        int high = board[0].length;
        boolean[][] vis = new boolean[width][high];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < high; j++) {
                if (check(board, word, vis, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * @param board
     * @param word
     * @param vis
     * @param i
     * @param j
     * @param k     代表走到第几个数字了
     * @return
     */
    private boolean check(char[][] board, String word, boolean[][] vis, int i, int j, int k) {
        if (board[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        } else {
            int width = board.length;
            int high = board[0].length;

            vis[i][j] = true;
            int[][] direc = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            for (int[] dir : direc) {
                int newi = dir[0] + i;
                int newj = dir[1] + j;
                if (newi >= 0 && newi < width && newj >= 0 && newj < high && !vis[newi][newj]) {
                    if (check(board, word, vis, newi, newj, k + 1)) {
                        return true;
                    }
                }
            }
            vis[i][j] = false;
            return false;
        }

    }

}
// @lc code=end
