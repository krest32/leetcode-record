/*
 * @lc app=leetcode.cn id=1456 lang=java
 *
 * [1456] 定长子串中元音的最大数目
 */

// @lc code=start
class Solution {
    public int maxVowels(String s, int k) {
        // 滑动窗口
        return extracted(s, k);
    }

    /**
     * 106/106 cases passed (11 ms)
     * Your runtime beats 83.59 % of java submissions
     * Your memory usage beats 11.98 % of java submissions (42.4 MB)
     * 
     * @param s
     * @param k
     * @return
     */
    private int extracted(String s, int k) {
        int n = s.length();
        int vowelCount = 0;
        for (int i = 0; i < k; i++) {
            vowelCount += isVowel(s.charAt(i));
        }
        int ans = vowelCount;
        for (int i = k; i < n; i++) {
            vowelCount += isVowel(s.charAt(i)) - isVowel(s.charAt(i - k));
            ans = Math.max(ans, vowelCount);
        }
        return ans;
    }

    private int isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ? 1 : 0;
    }
}
// @lc code=end
