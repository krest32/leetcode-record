/*
 * @lc app=leetcode.cn id=1638 lang=java
 *
 * [1638] 统计只差一个字符的子串数目
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s, String t) {
        // 中心扩散法
        return extracted(s, t);

        // 推荐 -》 代码相对比较简单
        // return extracted2(s, t);

    }

    /**
     * 63/63 cases passed (8 ms)
     * Your runtime beats 37.37 % of java submissions
     * Your memory usage beats 79.8 % of java submissions (39.2 MB)
     * 
     * @param s
     * @param t
     * @return
     */
    private int extracted2(String s, String t) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                // 找到一个两个不同的字符，然后分别向右和向左扩散，截至找到存在第二个不用的字符
                // 然后左侧的*右侧的字符就是当前位置字
                if (s.charAt(i) != t.charAt(j)) {
                    int left = 1;
                    int right = 1;
                    while (i + right < s.length()
                            && j + right < t.length()
                            && s.charAt(i + right) == t.charAt(j + right)) {
                        right++;
                    }
                    while (i - left >= 0
                            && j - left >= 0
                            && s.charAt(i - left) == t.charAt(j - left)) {
                        left++;
                    }
                    res += left * right;
                }
            }
        }
        return res;
    }

    /**
     * 63/63 cases passed (3 ms)
     * Your runtime beats 89.9 % of java submissions
     * Your memory usage beats 34.34 % of java submissions (41 MB)
     * 
     * @param s
     * @param t
     * @return
     */
    private int extracted(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int count = 0;
        // start[i][j] 表示 以s[i]与t[j]开头，相同的字符串长度
        int[][] start = new int[charS.length][charT.length];
        for (int i = charS.length - 1; i >= 0; i--) {
            for (int j = charT.length - 1; j >= 0; j--) {
                if (charS[i] != charT[j])
                    continue;
                start[i][j] = i == charS.length - 1 || j == charT.length - 1
                        ? 1
                        : start[i + 1][j + 1] + 1;
            }
        }
        // end[i][j] 表示 以s[i]与t[j]结尾，相同的字符串长度
        int[][] end = new int[charS.length][charT.length];
        for (int i = 0; i < charS.length; i++) {
            for (int j = 0; j < charT.length; j++) {
                if (charS[i] != charT[j])
                    continue;
                end[i][j] = i == 0 || j == 0
                        ? 1
                        : end[i - 1][j - 1] + 1;
            }
        }
        for (int i = 0; i < charS.length; i++) {
            for (int j = 0; j < charT.length; j++) {
                if (charS[i] == charT[j])
                    continue;
                int left = i > 0 && j > 0 ? end[i - 1][j - 1] : 0;
                int right = i < charS.length - 1 && j < charT.length - 1
                        ? start[i + 1][j + 1]
                        : 0;
                count += (left + 1) * (right + 1);
            }
        }
        return count;
    }

}
// @lc code=end
