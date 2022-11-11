/*
 * @lc app=leetcode.cn id=1784 lang=java
 *
 * [1784] 检查二进制字符串字段
 */

// @lc code=start
class Solution {
    public boolean checkOnesSegment(String s) {
        // 不能包含“01”
        return extracted(s);
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 9.29 % of java submissions (39.7 MB)
     * 
     * @param s
     * @return
     */
    private boolean extracted(String s) {
        return !s.contains("01");
    }
}
// @lc code=end
