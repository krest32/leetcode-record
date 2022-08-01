/*
 * @lc app=leetcode.cn id=1614 lang=java
 *
 * [1614] 括号的最大嵌套深度
 */

// @lc code=start
class Solution {
    public int maxDepth(String s) {
        // 模拟
        return extracted(s);
    }

    /**
     * 167/167 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 12.57 % of java submissions (39.8 MB)
     * 
     */
    private int extracted(String s) {
        int maxDepth = 0;
        int curDepth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                curDepth++;
            }
            if (ch == ')' && maxDepth > 0) {
                curDepth--;
            }
            maxDepth = Math.max(maxDepth, curDepth);
        }
        return maxDepth;
    }
}
// @lc code=end
