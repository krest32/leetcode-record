import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        // 动态规划 -- 01 背包
        // dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
        // return extracted(nums);

        // test
        return test(nums);

    }

    private boolean test(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;
        boolean[][] dp = new boolean[len + 1][half + 1];

        for (int i = 1; i <= len; i++) {
            int curVal = nums[i-1];
            for (int j = 0; j <= half; j++) {
                
                dp[i][j] = dp[i - 1][j];
                if (curVal == j) {
                    dp[i][j] = true;
                }
                if (curVal < j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - curVal];
                }
            }
        }
        return dp[len][half];
    }

    /**
     * Your runtime beats 6.03 % of java submissions
     * Your memory usage beats 26.9 % of java submissions (42.2 MB)
     * 
     * @param nums
     * @return
     */
    private boolean extracted(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1)
            return false;
        int halfSum = sum / 2;
        boolean[][] dp = new boolean[n + 1][halfSum + 1];

        for (int i = 1; i <= n; i++) {
            int curValue = nums[i - 1];
            for (int j = 0; j <= halfSum; j++) {
                // 当前 i 个元素，是否能够正好累加变成 j
                dp[i][j] = dp[i - 1][j];
                if (curValue == j) {
                    dp[i][j] = true;
                }
                if (curValue < j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - curValue];
                }
            }
        }
        return dp[n][halfSum];
    }
}
// @lc code=end
