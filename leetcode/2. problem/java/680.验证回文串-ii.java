/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文串 II
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        return extracted(s);
    }

    /**
     * 469/469 cases passed (6 ms)
     * Your runtime beats 55.19 % of java submissions
     * Your memory usage beats 58.41 % of java submissions (42 MB)
     * 
     * @param s
     * @return
     */
    private boolean extracted(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left + 1, right)
                        || isPalindrome(s, left, right - 1);

            }
        }
        return true;
    }

    boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
// @lc code=end
