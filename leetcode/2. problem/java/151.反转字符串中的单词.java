/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        return extracted(s);
    }

    /**
     * 58/58 cases passed (7 ms)
     * Your runtime beats 51.53 % of java submissions
     * Your memory usage beats 42.69 % of java submissions (41.4 MB)
     * 
     * @param s
     * @return
     */
    private String extracted(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder ret = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].indexOf(" ") >= 0 || str[i].indexOf(' ') >= 0) {
                continue;
            }
            if (str[i].length() > 0) {
                if (i != 0) {
                    ret.append(str[i] + " ");
                } else {
                    ret.append(str[i]);
                }
            }
        }
        return ret.toString();
    }
}
// @lc code=end
