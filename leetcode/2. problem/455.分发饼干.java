import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // 排序+贪心
        return extracted(g, s);
    }

    /**
     * 21/21 cases passed (7 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 60.18 % of java submissions (42.3 MB)
     * 
     * @param g
     * @param s
     * @return
     */
    private int extracted(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cookies = 0;
        int childs = 0;
        while (cookies < s.length && childs < g.length) {
            if (s[cookies] >= g[childs]) {
                cookies++;
                childs++;
            } else {
                cookies++;
            }
        }
        return childs;
    }
}
// @lc code=end
