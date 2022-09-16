/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        // 动态规划
        // return extracted(nums);
        
        return test(nums);

    }

    private int test(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    /**
     * 54/54 cases passed (55 ms)
     * Your runtime beats 71.96 % of java submissions
     * Your memory usage beats 74.09 % of java submissions (40.8 MB)
     */
    private int extracted(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        // 记录每个左边位置上的最长子序列
        int[] dp = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
// @lc code=end
