/**
 * @lc app=leetcode.cn id=283 lang=java
 *
 *     [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // extracted(nums);

        test(nums);
    }

    private void test(int[] nums) {
        int j = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j + 1; i < len; i++) {
            nums[i] = 0;
        }
    }

    private void extracted(int[] nums) {
        int j = 0;
        // 双指针，移动非0元素到数组前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
// @lc code=end
