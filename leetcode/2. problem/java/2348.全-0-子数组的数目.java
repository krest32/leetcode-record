/*
 * @lc app=leetcode.cn id=2348 lang=java
 *
 * [2348] 全 0 子数组的数目
 */

// @lc code=start
class Solution {
    public long zeroFilledSubarray(int[] nums) {

        // 动态规划 -- 但是需要两次遍历
        // return extracted(nums);

        // 动态规划优化 -- 45.24% 三个变量
        // return extracted2(nums);

        // 动态规划优化 推荐： -- 79.11 % 三个变量
        // return extracted3(nums);

        // 动态规划优化 -- 79.11 % 两个变量，但是理解起来有些困难
        // return extracted4(nums);

        // test
        return test(nums);
    }

    private long test(int[] nums) {
        int len = nums.length;
        long[] dp = new long[len];
        dp[0] = nums[0] == 0 ? 1L : 0L;
        long ans = dp[0];
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            if (num != 0) {
                dp[i] = 0L;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            ans += dp[i];
        }
        return ans;
    }

    /**
     * 48/48 cases passed (3 ms)
     * Your runtime beats 79.11 % of java submissions
     * Your memory usage beats 70.09 % of java submissions (58.3 MB)
     */
    private long extracted3(int[] nums) {
        long pre = 0, cur = 0, ans = 0;
        for (int x : nums) {
            if (x != 0) {
                cur = 0;
            } else {
                cur = pre + 1;
            }
            ans += cur;
            pre = cur;
        }
        return ans;
    }

    /**
     * 48/48 cases passed (4 ms)
     * Your runtime beats 32.38 % of java submissions
     * Your memory usage beats 5.18 % of java submissions (60.8 MB)
     */
    private long extracted(int[] nums) {
        int len = nums.length;
        long[] dp = new long[len];
        dp[0] = nums[0] == 0 ? 1L : 0L;
        long ans = dp[0];
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            if (num != 0) {
                dp[i] = 0L;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            ans += dp[i];
        }
        return ans;
    }

    /**
     * 48/48 cases passed (4 ms)
     * Your runtime beats 45.24 % of java submissions
     * Your memory usage beats 86.84 % of java submissions (58.1 MB)
     */
    private long extracted2(int[] nums) {
        int len = nums.length;
        long pre = 0, cur = 0, ans = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                cur = 0;
            } else {
                if (i > 0) {
                    cur = pre + 1;
                } else {
                    cur = 1;
                }
            }
            ans += cur;
            pre = cur;
        }
        return ans;
    }

    /**
     * 48/48 cases passed (2 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 31.44 % of java submissions (58.7 MB)
     */
    private long extracted4(int[] nums) {
        long count = 0;// 答案
        int zeroCnt = 0;// 当前0的个数
        for (int x : nums) {
            if (x == 0) {
                zeroCnt++;
                count += zeroCnt;
            } else {
                zeroCnt = 0;
            }
        }
        return count;
    }
}
// @lc code=end
