
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // 首尾双指针
        // return extracted(nums);

        // 1
        return test(nums);
    }

    private int test(int[] nums) {
        if (isSorted(nums)) {
            return 0;
        }
        int[] ret = new int[nums.length];
        System.arraycopy(nums, 0, ret, 0, nums.length);
        Arrays.sort(ret);

        int left = 0;
        int right = nums.length - 1;
        while (nums[left] == ret[left]) {
            left++;
        }
        while (nums[right] == ret[right]) {
            right--;
        }
        return right - left + 1;
    }

    private int extracted(int[] nums) {
        // 判断数组是否已经排序
        if (isSorted(nums)) {
            return 0;
        }
        // 对数组进行 copy、排序
        int[] numsSorted = new int[nums.length];
        System.arraycopy(nums, 0, numsSorted, 0, nums.length);
        Arrays.sort(numsSorted);

        // 查找区间数字
        int left = 0;
        while (nums[left] == numsSorted[left]) {
            left++;
        }
        int right = nums.length - 1;
        while (nums[right] == numsSorted[right]) {
            right--;
        }
        // 返回区间的长度
        return right - left + 1;
    }

    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
