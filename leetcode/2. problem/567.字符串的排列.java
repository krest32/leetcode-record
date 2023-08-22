import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 滑动窗口
        // return extracted(s1, s2);

        // test
        return test(s1, s2);
    }

    private boolean test(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < len1; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = len1; i < len2; i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - len1) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 108/108 cases passed (5 ms)
     * Your runtime beats 79 % of java submissions
     * Your memory usage beats 66.99 % of java submissions (41.3 MB)
     * 
     * @param s1
     * @param s2
     * @return
     */
    private boolean extracted(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < len1; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        for (int i = len1; i < len2; i++) {
            // 维持一个s1.length窗口，进行字符的控制，
            // 然后判断字符是否相同
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - len1) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
