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
        // return extracted(n);

        // test
        return test(n);

    }

    /**
     * 8/8 cases passed (1 ms)
     * Your runtime beats 75.93 % of java submissions
     * Your memory usage beats 45.26 % of java submissions (41.5 MB)
     * 
     * @param n
     * @return
     */
    private List<String> test(int n) {
        List<String> ans = new ArrayList<>();
        backTrackTest(ans, 0, 0, n, new StringBuilder());
        return ans;
    }

    private void backTrackTest(List<String> ans, int left, int right, int n, StringBuilder temp) {
        if (temp.length() == 2 * n) {
            ans.add(temp.toString());
        } else {
            if (left < n) {
                temp.append("(");
                backTrackTest(ans, left + 1, right, n, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
            if (right < left) {
                temp.append(")");
                backTrackTest(ans, left, right + 1, n, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }

    }

    private List<String> extracted(int n) {
        List<String> res = new ArrayList<>();
        backTrack(res, new StringBuilder(), n, 0, 0);
        return res;
    }

    private void backTrack(List<String> res, StringBuilder temp, int n, int left, int right) {
        // 终止条件
        if (temp.length() == n * 2) {
            res.add(temp.toString());
            return;
        }
        // 括号左边计数
        if (left < n) {
            temp.append("(");
            backTrack(res, temp, n, left + 1, right);
            temp.deleteCharAt(temp.length() - 1);
        }
        // 括号右边数，右边不能大于左边
        if (right < left) {
            temp.append(")");
            backTrack(res, temp, n, left, right + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
// @lc code=end
