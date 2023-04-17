/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // 动态规划 1
        // return extracted(nums);

        // test
        return test(nums);
    }

    private int test(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            // 从 0 开始
            int max1 = getMaxValue(nums, 0, len - 1);
            int max2 = getMaxValue(nums, 1, len);
            return Math.max(max1, max2);
        }

    }

    private int getMaxValue(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end - 1];
    }

    /**
     * 75/75 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 51.33 % of java submissions (38.9 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int len = nums.length;
            // 第一种，从0开始，到len-2结束
            int robValue1 = value(nums, 0, len - 2);
            // 第二种，从1开始，到lne-1结束
            int robValue2 = value(nums, 1, len - 1);
            return Math.max(robValue1, robValue2);
        }
    }

    private int value(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end];
    }
}
// @lc code=end
