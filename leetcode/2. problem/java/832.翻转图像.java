/*
 * @lc app=leetcode.cn id=832 lang=java
 *
 * [832] 翻转图像
 */

// @lc code=start
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        // 模拟优化
        // return extracted(image);

        // test
        return test(image);
    }

    private int[][] test(int[][] image) {
        int rows = image.length, colums = image[0].length;
        int[][] ans = new int[rows][colums];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                ans[i][colums - 1 - j] = image[i][j] == 1 ? 0 : 1;
            }
        }
        return ans;
    }

    /**
     * 82/82 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 56.31 % of java submissions (41.6 MB)
     * 
     * @param image
     * @return
     */
    private int[][] extracted(int[][] image) {
        int len = image.length, len2 = image[0].length;
        int[][] nums = new int[len][len2];
        for (int i = 0; i < len; i++) {
            len2 = image[0].length;
            // 翻转左边，直接给新的数组进行赋值
            for (int j = 0, k = len2 - 1; j < len2; j++, k--) {
                nums[i][k] = image[i][j] == 1 ? 0 : 1;
            }
        }
        return nums;
    }
}
// @lc code=end
