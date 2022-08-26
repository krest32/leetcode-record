import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=945 lang=java
 *
 * [945] 使数组唯一的最小增量
 */

// @lc code=start
class Solution {
    public int minIncrementForUnique(int[] nums) {
        return extracted(nums);
    }

    /**
     * 计数法, 统计每个字符的数量
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int ans = 0, taken = 0;
        // 开始遍历所有元素
        for (int i = 1; i < nums.length; i++) {
            // 如果前后两个元素相等
            if (nums[i - 1] == nums[i]) {
                taken++;
                ans -= nums[i];

            } else {
                int give = Math.min(taken, nums[i] - nums[i - 1] - 1);
                ans += give * (give + 1) / 2 + give * nums[i - 1];
                taken -= give;
            }
        }
        if (nums.length > 0) {
            ans += taken * (taken + 1) / 2 + taken * nums[nums.length - 1];
        }
        return ans;
    }
}
// @lc code=end
