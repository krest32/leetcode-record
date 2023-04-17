/*
 * @lc app=leetcode.cn id=795 lang=java
 *
 * [795] 区间子数组个数
 */

// @lc code=start
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // 动态规划 思维还是很巧妙的
        // return extracted(nums, left, right);

        // test
        // return test(nums, left, right);
    }

    private int test(int[] nums, int left, int right) {
        int len = nums.length;
        // preless 记录小于left的个数， preMatch 记录在区间中的子数组个数
        int total = 0, preLess = 0, preMatch = 0;
        for (int i = 1; i <= len; i++) {
            int curNum = nums[i - 1];
            if (curNum < left) {
                preLess++;
            } else if (curNum <= right) {
                preMatch = preLess + preMatch + 1;
                preLess = 0;
            } else {
                preLess = 0;
                preMatch = 0;
            }
            total += preMatch;
        }
        return total;
    }

    /**
     * 46/46 cases passed (3 ms)
     * Your runtime beats 92.72 % of java submissions
     * Your memory usage beats 61.53 % of java submissions (48.7 MB)
     * 
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int extracted(int[] nums, int left, int right) {
        int preLess = 0;
        int preMatch = 0;
        int total = 0;
        for (int idx = 0; idx < nums.length; ++idx) {
            // < left, 能够作为子数组的一部分
            if (nums[idx] < left) {
                preLess = preLess + 1;
                // <right 能够独立生成一个子数组，同时自己为核心
            } else if (nums[idx] <= right) {
                // 精髓部分：记录个数的一种方案
                preMatch = preLess + preMatch + 1;
                preLess = 0;
            } else {
                preLess = 0;
                preMatch = 0;
            }
            total += preMatch;
        }
        return total;
    }
}
// @lc code=end
