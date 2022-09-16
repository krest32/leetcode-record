/*
 * @lc app=leetcode.cn id=673 lang=java
 *
 * [673] 最长递增子序列的个数
 */

// @lc code=start
class Solution {
    public int findNumberOfLIS(int[] nums) {
        // 动态规划
        // return extracted(nums);

        // test
        return test(nums);

    }

    private int test(int[] nums) {
        int len = nums.length, maxLen = 0, ans = 0;
        int[] dp = new int[len];
        int[] cnt = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                ans = cnt[i];
            } else if (maxLen == dp[i]) {
                ans += cnt[i];
            }
        }
        return ans;
    }

    /**
     * 223/223 cases passed (18 ms)
     * Your runtime beats 75.26 % of java submissions
     * Your memory usage beats 46.49 % of java submissions (41.2 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        int n = nums.length, maxLen = 0, ans = 0;
        // dp[i] 表示以 nums[i] 结尾的最长上升子序列的长度 dp[i]=max(dp[j])+1
        int[] dp = new int[n];
        // cnt[i] 表示以 nums[i] 结尾的最长上升子序列的个数
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                // 此处是个难点
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            // 更新结果
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i];
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}
// @lc code=end
