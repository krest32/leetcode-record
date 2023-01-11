/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        // return extracted(nums);

        // test
        return test(nums);
    }

    private boolean test(int[] nums) {
        int v1 = Integer.MAX_VALUE;
        int v2 = Integer.MAX_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (v1 >= nums[i]) {
                v1 = nums[i];
            } else if (v2 >= nums[i] && nums[i] > v1) {
                v2 = nums[i];
            } else if (nums[i] > v2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 77/77 cases passed (2 ms)
     * Your runtime beats 91.88 % of java submissions
     * Your memory usage beats 18.41 % of java submissions (91.4 MB)
     * 
     * @param nums
     * @return
     */
    private boolean extracted(int[] nums) {
        int fisrtNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (fisrtNum >= nums[i]) {
                fisrtNum = nums[i];
            } else if (secondNum >= nums[i] && nums[i] > fisrtNum) {
                secondNum = nums[i];
            } else if (nums[i] > secondNum) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
