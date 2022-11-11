import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1985 lang=java
 *
 * [1985] 找出数组中的第 K 大整数
 */

// @lc code=start
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        return extracted(nums, k);
    }

    /**
     * 219/219 cases passed (15 ms)
     * Your runtime beats 96.77 % of java submissions
     * Your memory usage beats 60.11 % of java submissions (47.6 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    private String extracted(String[] nums, int k) {
        Arrays.sort(nums, ((o1, o2) -> {
            return o1.length() == o2.length()
                    ? o2.compareTo(o1)
                    : o2.length() - o1.length();
        }));
        return String.valueOf(nums[k - 1]);
    }
}
// @lc code=end
