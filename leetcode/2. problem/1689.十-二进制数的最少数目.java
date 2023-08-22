/*
 * @lc app=leetcode.cn id=1689 lang=java
 *
 * [1689] 十-二进制数的最少数目
 */

// @lc code=start
class Solution {
    public int minPartitions(String str) {
        // 模拟 找到字符串中最大的数字即可
        return extracted(str);
    }

    /**
     * 97/97 cases passed (6 ms)
     * Your runtime beats 61.71 % of java submissions
     * Your memory usage beats 7.13 % of java submissions (42.4 MB)
     */
    private int extracted(String str) {
        char ans = '0';
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch > ans) {
                ans = ch;
            }
        }
        return ans - '0';
    }
}
// @lc code=end
