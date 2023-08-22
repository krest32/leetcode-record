import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=532 lang=java
 *
 * [532] 数组中的 k-diff 数对
 */

// @lc code=start
class Solution {
    public int findPairs(int[] nums, int k) {
        // 很精妙的一种思维
        // return extracted(nums, k);

        return test(nums, k);
    }

    private int test(int[] nums, int k) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                ans.add(num - k);
            }
            if (visited.contains(num + k)) {
                ans.add(num);
            }
            visited.add(num);
        }
        return ans.size();
    }

    /**
     * 60/60 cases passed (9 ms)
     * Your runtime beats 56.46 % of java submissions
     * Your memory usage beats 35.02 % of java submissions (42 MB)
     */
    private int extracted(int[] nums, int k) {
        Set<Integer> visited = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for (int num : nums) {
            if (visited.contains(num - k)) {
                res.add(num - k);
            }
            if (visited.contains(num + k)) {
                res.add(num);
            }
            visited.add(num);
        }
        return res.size();
    }
}
// @lc code=end
