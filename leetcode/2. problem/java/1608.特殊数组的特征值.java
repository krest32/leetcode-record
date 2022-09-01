import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1608 lang=java
 *
 * [1608] 特殊数组的特征值
 */

// @lc code=start
class Solution {
    public int specialArray(int[] nums) {
        // 暴力
        return extracted(nums);
    }

    /**
     * 98/98 cases passed (1 ms)
     * Your runtime beats 81.37 % of java submissions
     * Your memory usage beats 15.59 % of java submissions (39.5 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 1; i <= length; i++) {
            // 倒数第i个元素大于等于i
            if (nums[length - i] >= i) {
                // 如果倒数第i个元素是第一个元素，也满足要求
                if (length - i == 0) {
                    return i;
                    // 倒数第i-1个元素小于i
                } else if (nums[length - 1 - i] < i) {
                    return i;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
