/*
 * @lc app=leetcode.cn id=1004 lang=java
 *
 * [1004] 最大连续1的个数 III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        // 滑動窗口
        // return extracted(nums, k);

        // 1
        return test(nums, k);

    }

    private int test(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int cntZero = 0;
        int maxLen = 0;
        while (right < len) {
            if (nums[right] == 0) {
                cntZero++;
            }
            while (cntZero > k) {
                if (nums[left] == 0) {
                    cntZero--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    /**
     * 52/52 cases passed (3 ms)
     * Your runtime beats 70.5 % of java submissions
     * Your memory usage beats 70.91 % of java submissions (42.7 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    private int extracted(int[] nums, int k) {
        int N = nums.length;
        int res = 0;
        int left = 0, right = 0;
        int zeros = 0;
        // 如果窗口内的0的个数大于k,那么就缩短left指针，动态调整窗口的大小
        while (right < N) {
            if (nums[right] == 0)
                zeros++;
            while (zeros > k) {
                if (nums[left++] == 0)
                    zeros--;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
// @lc code=end
