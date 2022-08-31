import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1930 lang=java
 *
 * [1930] 长度为 3 的不同回文子序列
 */

// @lc code=start
class Solution {
    public int countPalindromicSubsequence(String s) {
        return extracted(s);

    }

    /**
     * 70/70 cases passed (201 ms)
     * Your runtime beats 35.92 % of java submissions
     * Your memory usage beats 35.92 % of java submissions (42.8 MB)
     * 
     * @param s
     * @return
     */
    private int extracted(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                for (int k = s.length() - 1; k > i + 1; k--) {
                    if (s.charAt(k) == ch) {
                        Set<Character> tempSet = new HashSet<>();
                        for (char temp : s.substring(i + 1, k).toCharArray()) {
                            tempSet.add(temp);
                        }
                        ans += tempSet.size();
                        break;
                    }
                }
            }
            set.add(ch);
        }
        return ans;
    }
}
// @lc code=end
