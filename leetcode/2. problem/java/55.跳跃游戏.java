
/**
 * @lc app=leetcode.cn id=55 lang=java
 *
 *     [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        // return extracted(nums);

        // test
        return test(nums);
    }

    private boolean test(int[] nums) {
        int ringhtMost = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i <= ringhtMost) {
                ringhtMost = Math.max(ringhtMost, i + nums[i]);
                if (ringhtMost >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 170/170 cases passed (2 ms)
     * Your runtime beats 93.99 % of java submissions
     * Your memory usage beats 6.95 % of java submissions (42.4 MB)
     * 
     * @param nums
     * @return
     */
    private boolean extracted(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            // 贪心
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, nums[i] + i);
                if (rightMost >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end
