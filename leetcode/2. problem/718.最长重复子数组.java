/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    public int findLength(int[] A, int[] B) {

        // 动态规划 倒序
        return extracted1(A, B);

        // 动态规划 正序
        // return extracted2(A, B);

        
    }

    /**
     * 53/53 cases passed (28 ms)
     * Your runtime beats 27.75 % of java submissions
     * Your memory usage beats 47.77 % of java submissions (50 MB)
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    private int extracted2(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int ans = 0;
        if (nums1[0] == nums2[0]) {
            dp[0][0] = 1;
        }
        for (int i = 0; i < len1; i++) {
            int num1 = nums1[i];
            for (int j = 0; j < len2; j++) {
                int num2 = nums2[j];
                if (num1 == num2) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    private int extracted1(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        /**
         * '为了避免重复比较
         * A[i:] 与 B[j:] 的最长公共前缀为
         * A[i + 1:] 与 B[j + 1:] 的最长公共前缀的长度加一
         * dp[i][j] = dp[i + 1][j + 1] + 1
         */
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = 0;
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
// @lc code=end
