/*
 * @lc app=leetcode.cn id=930 lang=java
 *
 * [930] 和相同的二元子数组
 */

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // 滑动窗口
        // return extracted(nums, goal);

        // test
        return test(nums, goal);
    }

    /**
     * 60/60 cases passed (2 ms)
     * Your runtime beats 98.78 % of java submissions
     * Your memory usage beats 45.23 % of java submissions (45.5 MB)
     * 
     * @param nums
     * @param goal
     * @return
     */
    private int test(int[] nums, int goal) {
        int len = nums.length;
        int sum1 = 0, sum2 = 0;
        int left1 = 0, left2 = 0, right = 0;
        int ans = 0;
        while (right < len) {
            sum1 += nums[right];
            sum2 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            ans += left2 - left1;
            right++;
        }
        return ans;

    }

    /**
     * 60/60 cases passed (2 ms)
     * Your runtime beats 95.37 % of java submissions
     * Your memory usage beats 75.37 % of java submissions (44.9 MB)
     * 
     * @param nums
     * @param goal
     * @return
     */
    private int extracted(int[] nums, int goal) {
        int len = nums.length;
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0;
        int ret = 0;
        // 区间 （left1 left2] 维持一个 等于goal 的状态
        // ret = left2 - left1个等于left的数组
        while (right < len) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }

            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            ret += left2 - left1;
            right++;
        }
        return ret;
    }
}
// @lc code=end
