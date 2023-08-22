/*
 * @lc app=leetcode.cn id=376 lang=java
 *
 * [376] 摆动序列
 */

// @lc code=start
class Solution {
    public int wiggleMaxLength(int[] nums) {
        // 摸你+贪心
        // return extracted(nums);

        // test
        return test(nums);
    }

    private int test(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int prevDiff = nums[1] - nums[0];
        int ret = prevDiff == 0 ? 1 : 2;
        for (int i = 2; i < len; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevDiff <= 0) || (diff < 0 && prevDiff >= 0)) {
                ret++;
                prevDiff = diff;
            }
        }
        return ret;
    }

    /**
     * 31/31 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 66.22 % of java submissions (39 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return len;
        int prevdiff = nums[1] - nums[0];
        int ret = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < len; i++) {
            int diff = nums[i] - nums[i - 1];
            // 贪心算法，三个数字之间不能是递增关系，仅仅记录差值
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                ret++;
                prevdiff = diff;
            }
        }
        return ret;
    }
}
// @lc code=end
