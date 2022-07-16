/*
 * @lc app=leetcode.cn id=2299 lang=java
 *
 * [2299] 强密码检验器 II
 */

// @lc code=start
class Solution {
    public boolean strongPasswordCheckerII(String password) {
        // 模拟
        return extracted(password);
    }

    /**
     * 148/148 cases passed (1 ms)
     * Your runtime beats 68.04 % of java submissions
     * Your memory usage beats 23.95 % of java submissions (39.8 MB)
     * 
     * @param password
     * @return
     */
    private boolean extracted(String password) {
        if (password.length() < 8)
            return false;
        int smallCnt = 0, bigCnt = 0, numCnt = 0, anthorCnt = 0, conCnt = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (i > 0 && ch == password.charAt(i - 1))
                conCnt++;
            if (Character.isDigit(ch)) {
                numCnt++;
            } else if (Character.isLetter(ch)) {
                if (Character.isLowerCase(ch)) {
                    smallCnt++;
                }
                if (Character.isUpperCase(ch)) {
                    bigCnt++;
                }
            } else {
                anthorCnt++;
            }
        }

        return numCnt > 0 && smallCnt > 0
                && bigCnt > 0 && anthorCnt > 0 && conCnt == 0;
    }
}
// @lc code=end
