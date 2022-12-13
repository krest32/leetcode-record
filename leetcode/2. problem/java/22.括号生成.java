import java.util.ArrayList;
import java.util.List;

/**
 * @lc app=leetcode.cn id=22 lang=java
 *
 *     [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        // 回溯
        return extracted(n);

    }

    /**
     * 8/8 cases passed (1 ms)
     * Your runtime beats 75.93 % of java submissions
     * Your memory usage beats 45.26 % of java submissions (41.5 MB)
     * 
     * @param n
     * @return
     */
    private List<String> extracted(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, new StringBuilder(), n, 0, 0);
        return res;
    }

    private void backTrack(List<String> ans, StringBuilder tempStr, int n, int left, int right) {
        if ((left + right) == (n * 2)) {
            ans.add(tempStr.toString());
        } else {
            if (left < n) {
                tempStr.append('(');
                backTrack(ans, tempStr, n, left + 1, right);
                tempStr.deleteCharAt(tempStr.length() - 1);
            }
            if (right < left) {
                tempStr.append(')');
                backTrack(ans, tempStr, n, left, right + 1);
                tempStr.deleteCharAt(tempStr.length() - 1);

            }
        }
    }
}
// @lc code=end
