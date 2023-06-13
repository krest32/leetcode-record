import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2138 lang=java
 *
 * [2138] 将字符串拆分为若干长度为 k 的组
 */

// @lc code=start
class Solution {
    public String[] divideString(String s, int k, char fill) {
        // 模拟，暴力
        return extracted(s, k, fill);
    }

    /**
     * 157/157 cases passed (1 ms)
     * Your runtime beats 86.41 % of java submissions
     * Your memory usage beats 5.93 % of java submissions (41.9 MB)
     * 
     * @param s
     * @param k
     * @param fill
     * @return
     */
    private String[] extracted(String s, int k, char fill) {
        List<StringBuilder> list = new ArrayList<>();
        int idx = 0;
        while (idx < s.length()) {
            StringBuilder str = new StringBuilder();
            while (str.length() < k && idx < s.length()) {
                str.append(s.charAt(idx));
                idx++;
            }
            list.add(str);
        }
        while (list.get(list.size() - 1).length() < k) {
            list.get(list.size() - 1).append(fill);
        }

        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i).toString();
        }
        return ans;
    }
}
// @lc code=end
