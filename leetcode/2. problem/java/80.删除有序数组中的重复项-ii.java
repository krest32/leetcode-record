/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        // 双指针
        // return extracted(nums);

        return test(nums);
    }

    private int test(int[] nums) {
        int len = nums.length;
        if (len <= 2)
            return len;
        int slow = 2, fast = 2;
        while (fast < len) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 164/164 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 52.16 % of java submissions (41.6 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
// @lc code=end
