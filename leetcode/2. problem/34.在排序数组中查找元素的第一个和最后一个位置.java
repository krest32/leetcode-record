/**
 * @lc app=leetcode.cn id=34 lang=java
 *
 *     [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 合理使用二分查找法
        // return extracted(nums, target);

        // test
        return test(nums, target);
    }

    /**
     * 88/88 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 90.68 % of java submissions (43.3 MB)
     * 
     * @param nums
     * @param target
     * @return
     */
    private int[] test(int[] nums, int target) {
        int left = findPos(nums, target);
        int right = findPos(nums, target + 1);
        if (left == nums.length || nums[left] != target) {
            return new int[] { -1, -1 };
        } else {
            return new int[] { left, right - 1 };
        }
    }

    /**
     * 88/88 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 55.87 % of java submissions (43.6 MB)
     * 
     * @param nums
     * @param target
     * @return
     */
    private int[] extracted(int[] nums, int target) {
        int start = find(nums, target);
        int end = find(nums, target + 1);
        if (start == nums.length || nums[start] != target) {
            return new int[] { -1, -1 };
        } else {
            return new int[] { start, end - 1 };
        }
    }

    private int findPos(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int find(int[] nums, int target) {
        int idx = 0;
        for (int nums2 : nums) {
            if (nums2 == target) {
                return idx;
            }
            idx++;
        }
        return idx;
    }

}
// @lc code=end
