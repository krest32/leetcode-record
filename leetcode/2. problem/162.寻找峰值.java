
/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        // 模拟
        return extracted(nums);
    }

    /**
     * 65/65 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 37.89 % of java submissions (40.9 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i - 1;
            }
        }
        return nums.length - 1;
    }
}
// @lc code=end
