import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        // 哈希
        // return extracted(nums);

        // return method2(nums);
    }

    /**
     * Time Limit Exceeded
     * 55/58 cases passed (N/A)
     * 
     * @param nums
     * @return
     */
    private int method2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int a = nums[i];
            for (int j = i + 1; j < len; j++) {
                int b = nums[j];
                if (a == b) {
                    return a;
                }
            }
        }
        return -1;
    }

    /**
     * Your runtime beats 37.75 % of java submissions
     * Your memory usage beats 40.83 % of java submissions (58.5 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;
    }
}
// @lc code=end
