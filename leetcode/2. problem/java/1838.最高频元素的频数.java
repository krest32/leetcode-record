import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1838 lang=java
 *
 * [1838] 最高频元素的频数
 */

// @lc code=start
class Solution {
    public int maxFrequency(int[] nums, int k) {
        // 排序 + 滑动窗口
        // return method1(nums, k);

        // 1
        return test(nums, k);
    }

    int test(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, res = 1, total = 0, len = nums.length;
        for (int i = 1; i < len; i++) {
            total += (nums[i] - nums[i - 1]) * (i - left);
            while (total > k) {
                total -= nums[i] - nums[left];
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    /**
     * 71/71 cases passed (29 ms)
     * Your runtime beats 99.11 % of java submissions
     * Your memory usage beats 64.58 % of java submissions (56.6 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    int method1(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, res = 1, total = 0, len = nums.length;
        for (int i = 1; i < len; i++) {
            total += (nums[i] - nums[i - 1]) * (i - left);
            while (total > k) {
                total -= nums[i] - nums[left];
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
// @lc code=end
