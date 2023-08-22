import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=473 lang=java
 *
 * [473] 火柴拼正方形
 */

// @lc code=start
class Solution {
    public boolean makesquare(int[] nums) {
        // 回溯 + 剪枝
        // return extracted(nums);

        // test
        return test(nums);
    }

    private boolean test(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int num : nums) {
            sum += num;
        }
        Arrays.sort(nums);
        int target = sum / 4;
        if (sum == 0 || sum % 4 != 0 || nums[len - 1] > target) {
            return false;
        }
        return backTrackTest(nums, target, new int[4], 0);
    }

    private boolean backTrackTest(int[] nums, int target, int[] size, int idx) {
        if (idx == nums.length) {
            if (size[0] == size[1] && size[1] == size[2] && size[2] == size[3]) {
                return true;
            }
            return false;
        } else {
            for (int i = 0; i < size.length; i++) {
                if (size[i] + nums[idx] > target || (i > 0 && size[i] == size[i - 1])) {
                    continue;
                }
                size[i] += nums[idx];
                if (backTrackTest(nums, target, size, idx + 1)) {
                    return true;
                }
                size[i] -= nums[idx];
            }
            return false;
        }
    }

    /**
     * 195/195 cases passed (168 ms)
     * Your runtime beats 14.28 % of java submissions
     * Your memory usage beats 41.99 % of java submissions (39.4 MB)
     * 
     * @param nums
     * @return
     */
    private boolean extracted(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total == 0 || (total % 4) != 0)
            return false;
        Arrays.sort(nums);
        // 回溯，从最长的火柴开始
        return backtrack(nums, nums.length - 1, total / 4, new int[4]);
    }

    /**
     * index表示访问到当前火柴的位置，
     * target表示正方形的边长，
     * size是长度为4的数组，分别保存正方形4个边的长度
     */
    private boolean backtrack(int[] nums, int index, int target, int[] size) {
        if (index == -1) {
            if (size[0] == size[1] && size[1] == size[2] && size[2] == size[3])
                return true;
            return false;
        }
        for (int i = 0; i < size.length; i++) {
            // 剪枝
            if (size[i] + nums[index] > target || (i > 0 && size[i] == size[i - 1]))
                continue;
            size[i] += nums[index];
            // 然后在放下一个火柴，如果最终能变成正方形，直接返回true
            if (backtrack(nums, index - 1, target, size))
                return true;
            // 如果当前火柴放到size[i]这个边上，最终不能构成正方形，我们就把他从
            // size[i]这个边上给移除，然后在试其他的边
            size[i] -= nums[index];
        }
        // 如果不能构成正方形，直接返回false
        return false;
    }
}
// @lc code=end
