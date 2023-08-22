/*
 * @lc app=leetcode.cn id=1952 lang=java
 *
 * [1952] 三除数
 */

// @lc code=start
class Solution {
    public boolean isThree(int n) {
        // 暴力破解
        return extracted(n);
    }

    /**
     * 228/228 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 83.92 % of java submissions (38.2 MB)
     */
    private boolean extracted(int n) {
        int cnt = 0;
        for (int x = 1; x < n + 1; x++) {
            if (n % x == 0) {
                cnt++;
                if (cnt > 3)
                    break;
            }
        }
        return cnt == 3;
    }
}
// @lc code=end
