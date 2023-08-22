/*
 * @lc app=leetcode.cn id=1492 lang=java
 *
 * [1492] n 的第 k 个因子
 */

// @lc code=start
class Solution {
    public int kthFactor(int n, int k) {
        return extracted(n, k);
    }

    /**
     * 208/208 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 97.57 % of java submissions (38 MB)
     * 
     * @param n
     * @param k
     * @return
     */
    private int extracted(int n, int k) {
        int count = 0;
        for (int factor = 1; factor <= n; ++factor) {
            if (n % factor == 0) {
                ++count;
                if (count == k) {
                    return factor;
                }
            }
        }
        return -1;
    }
}
// @lc code=end
