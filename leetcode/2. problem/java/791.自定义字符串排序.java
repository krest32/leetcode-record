/*
 * @lc app=leetcode.cn id=791 lang=java
 *
 * [791] 自定义字符串排序
 */

// @lc code=start
class Solution {
    public String customSortString(String order, String s) {
        return extracted(order, s);
    }

    /**
     * 39/39 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 55.53 % of java submissions (39.6 MB)
     * 
     * @param order
     * @param s
     * @return
     */
    private String extracted(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        StringBuilder ans = new StringBuilder();

        for (char c : order.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; i++)
                ans.append(c);
            count[c - 'a'] = 0;
        }

        for (char c = 'a'; c <= 'z'; c++)
            for (int i = 0; i < count[c - 'a']; i++)
                ans.append(c);
        return ans.toString();
    }
}
// @lc code=end
