/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口
        // return extracted(target, nums);

        // test
        return test(target, nums);
    }

    private int test(int target, int[] nums) {
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int right = 0;
        int left = 0;
        while (right < len) {
            sum += nums[right];
            while (left <= right && sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 20/20 cases passed (1 ms)
     * Your runtime beats 99.99 % of java submissions
     * Your memory usage beats 52.35 % of java submissions (48.8 MB)
     * 
     * @param target
     * @param nums
     * @return
     */
    private int extracted(int target, int[] nums) {
        int n = nums.length;
        // 判断特殊情况
        if (n == 0)
            return 0;

        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        //
        while (end < n) {
            // 记录窗口的值
            sum += nums[end];
            // 判断满足条件的子数组
            while (sum >= target) {
                // 记录最短长度
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
// @lc code=end
