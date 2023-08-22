/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // 固定滑动窗口
        // return extracted(nums, k);

        // 1
        return test(nums, k);

    }

    private double test(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return 1.0 * max / k;

    }

    /**
     * 127/127 cases passed (2 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 24.9 % of java submissions (57.6 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    private double extracted(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            if (sum > max) {
                max = sum;
            }
        }
        return 1.0 * max / k;
    }
}
// @lc code=end
