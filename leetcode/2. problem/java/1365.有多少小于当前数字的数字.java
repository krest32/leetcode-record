import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1365 lang=java
 *
 * [1365] 有多少小于当前数字的数字
 */

// @lc code=start
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 暴力 双循环
        return extracted(nums);

 
    }


    /**
     * 103/103 cases passed (10 ms)
     * Your runtime beats 26.92 % of java submissions
     * Your memory usage beats 22.17 % of java submissions (41.9 MB)
     * 
     * @param nums
     * @return
     */
    private int[] extracted(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] < nums[i]) {
                    cnt++;
                }
            }
            ret[i] = cnt;
        }
        return ret;
    }
}
// @lc code=end
