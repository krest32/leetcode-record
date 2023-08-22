/*
 * @lc app=leetcode.cn id=2206 lang=java
 *
 * [2206] 将数组划分成相等数对
 */

// @lc code=start
class Solution {
    public boolean divideArray(int[] nums) {
        return extracted(nums);
    }

    /**
     * 133/133 cases passed (1 ms)
     * Your runtime beats 99.81 % of java submissions
     * Your memory usage beats 42.7 % of java submissions (41.6 MB)
     * 
     * @param nums
     * @return
     */
    private boolean extracted(int[] nums) {
        int len = nums.length;
        if (len % 2 != 0) {
            return false;
        }
        int[] cnt = new int[501];
        for (int num : nums) {
            cnt[num]++;
        }

        for (int num : cnt) {
            if (num % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
