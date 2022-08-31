/*
 * @lc app=leetcode.cn id=2022 lang=java
 *
 * [    ] 将一维数组转变成二维数组
 */

// @lc code=start
class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // 简单模拟
        return extracted(original, m, n);
    }

    /**
     * 107/107 cases passed (3 ms)
     * Your runtime beats 98.22 % of java submissions
     * Your memory usage beats 27.6 % of java submissions (51.1 MB)
     * 
     * @param original
     * @param m
     * @param n
     * @return
     */
    private int[][] extracted(int[] original, int m, int n) {
        int len = original.length;
        if (len != m * n) {
            return new int[][] {};
        }
        int[][] ans = new int[m][n];
        int idx = 0;
        int newi = 0;
        while (idx < len) {
            int cnt = 0;
            while (cnt < n) {
                ans[newi][cnt] = original[idx];
                cnt++;
                idx++;
            }
            newi++;
        }
        return ans;
    }
}
// @lc code=end
