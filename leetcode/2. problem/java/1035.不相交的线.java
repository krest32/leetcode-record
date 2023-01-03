/*
 * @lc app=leetcode.cn id=1035 lang=java
 *
 * [1035] 不相交的线
 */

// @lc code=start
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 动态规划
        // return extracted(nums1, nums2);

        // 1
        return test(nums1, nums2);
    }

    private int test(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            int num1 = nums1[i - 1];
            for (int j = 1; j <= len2; j++) {
                int num2 = nums2[j - 1];
                if (num1 == num2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    /**
     * 74/74 cases passed (4 ms)
     * Your runtime beats 99.41 % of java submissions
     * Your memory usage beats 6.58 % of java submissions (41.4 MB)
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    private int extracted(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        // 表示数字左边为i，j时，不相交的线
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            int num1 = nums1[i - 1];
            for (int j = 1; j <= n; j++) {
                int num2 = nums2[j - 1];
                if (num1 == num2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end
