/*
 * @lc app=leetcode.cn id=832 lang=java
 *
 * [832] 翻转图像
 */

// @lc code=start
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        // 模拟 一步到位
        // return extracted(image);

        // test
        return test(image);
    }

    private int[][] test(int[][] image) {
        int row = image.length, column = image[0].length;
        int[][] ans = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                ans[i][j] = image[i][column - 1 - j] == 0 ? 1 : 0;
            }
        }
        return ans;
    }

    /**
     * 82/82 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 35.21 % of java submissions (41.8 MB)
     * 
     * @param image
     * @return
     */
    private int[][] extracted(int[][] image) {
        int rows = image.length, colums = image[0].length;
        // 新的图像数组
        int[][] ans = new int[rows][colums];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                //
                ans[i][colums - 1 - j] = image[i][j] == 1 ? 0 : 1;
            }
        }
        return ans;
    }
}
// @lc code=end
