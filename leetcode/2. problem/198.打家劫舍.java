/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // 动态规划，获取最值
        // return extracted(nums);

        // 1
        return test(nums);

    }

    private int test(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        if (nums == null || len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    /**
     * 70/70 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 18.56 % of java submissions (39.2 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {

        // dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
// @lc code=end
