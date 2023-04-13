/*
 * @lc app=leetcode.cn id=2016 lang=java
 *
 * [2016] 增量元素之间的最大差值
 */

// @lc code=start
class Solution {
    public int maximumDifference(int[] nums) {
        // 动态规划 一
        // return extracted(nums);

        // 动态规划 二
        // return extracted2(nums);

        // test
        return test(nums);
    }

    private int test(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        int maxDiff = -1;
        for (int i = 1; i < len; i++) {
            dp[i] = Math.min(nums[i], dp[i - 1]);
            maxDiff = Math.max(maxDiff, nums[i] - dp[i]);
        }
        return maxDiff == 0 ? -1 : maxDiff;
    }

    /**
     * 54/54 cases passed (1 ms)
     * Your runtime beats 44.36 % of java submissions
     * Your memory usage beats 23.74 % of java submissions (40.9 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        int maxDiff = -1;
        for (int i = 1; i < len; i++) {
            dp[i] = Math.min(nums[i], dp[i - 1]);
            maxDiff = Math.max(maxDiff, nums[i] - dp[i]);
        }
        return maxDiff == 0 ? -1 : maxDiff;
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 44.37 % of java submissions (40.7 MB)
     */
    private int extracted(int[] nums) {
        int ret = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (min >= nums[i]) {
                min = nums[i];
            } else if (ret < nums[i] - min) {
                ret = nums[i] - min;
            }
        }

        return ret;
    }
}
// @lc code=end
