/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        // 动态规划
        // return extracted(nums);

        // test
        return test(nums);
    }

    private int test(int[] nums) {
        int len = nums.length;
        int[] maxDp = new int[len];
        int[] minDp = new int[len];
        maxDp[0] = nums[0];
        minDp[0] = nums[0]; 
        for (int i = 1; i < len; i++) {
            maxDp[i] = Math.max(maxDp[i - 1] * nums[i], Math.max(nums[i], minDp[i - 1] * nums[i]));
            minDp[i] = Math.min(minDp[i - 1] * nums[i], Math.min(nums[i], maxDp[i - 1] * nums[i]));
        }
        int ans = maxDp[0];
        for (int i = 1; i < len; i++) {
            ans = Math.max(ans, maxDp[i]);
        }
        return ans;
    }

    private int extracted(int[] nums) {
        int len = nums.length;
        int[] maxDp = new int[len];
        int[] minDp = new int[len];
        maxDp[0] = nums[0];
        minDp[0] = nums[0]; 
        for (int i = 1; i < len; i++) {
            maxDp[i] = Math.max(maxDp[i - 1] * nums[i], Math.max(nums[i], minDp[i - 1] * nums[i]));
            minDp[i] = Math.min(minDp[i - 1] * nums[i], Math.min(nums[i], maxDp[i - 1] * nums[i]));
        }
        int ans = maxDp[0];
        for (int i = 1; i < len; i++) {
            ans = Math.max(ans, maxDp[i]);
        }
        return ans;
    }
}
// @lc code=end
