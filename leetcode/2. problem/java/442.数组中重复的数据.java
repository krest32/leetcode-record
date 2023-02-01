import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=442 lang=java
 *
 * [442] 数组中重复的数据
 */

// @lc code=start
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        /**
         * 找到数字i时，将位置i-1处的数字翻转为负数。
         * 如果位置i-1 上的数字已经为负，则i是出现两次的数字。
         */
        // return extracted(nums);

        // test
        return test(nums);
    }

    private List<Integer> test(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0) {
                ans.add(idx + 1);
            }
            nums[idx] = -nums[idx];
        }
        return ans;
    }

    /**
     * 28/28 cases passed (5 ms)
     * Your runtime beats 83.52 % of java submissions
     * Your memory usage beats 50.64 % of java submissions (49.5 MB)
     * 
     * @param nums
     * @return
     */
    private List<Integer> extracted(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
// @lc code=end
