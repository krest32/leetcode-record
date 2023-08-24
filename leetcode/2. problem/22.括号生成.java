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

        // 回溯简化
        return extracted2(n);

        // test
        // return test(n);

    }

    private List<String> test(int n) {
        List<String> ans = new ArrayList<>();
        backTrackTest(ans, new StringBuilder(), n, 0, 0);
        return ans;
    }

    private void backTrackTest(List<String> ans, StringBuilder tempStr, int n, int left, int right) {
        if (left + right == n * 2) {
            ans.add(new String(tempStr));
        } else {
            if (left < n) {
                tempStr.append("(");
                backTrackTest(ans, tempStr, n, left + 1, right);
                tempStr.deleteCharAt(tempStr.length() - 1);
            }
            if (right < left) {
                tempStr.append(")");
                backTrackTest(ans, tempStr, n, left, right + 1);
                tempStr.deleteCharAt(tempStr.length() - 1);
            }
        }
    }

    /**
     * 回溯方法简化,通过string的值传递解决
     * 8/8 cases passed (1 ms)
     * Your runtime beats 73.07 % of java submissions
     * Your memory usage beats 53.65 % of java submissions (41 MB)
     * 
     * @param n
     * @return
     */
    private List<String> extracted2(int n) {
        List<String> ans = new ArrayList<>();
        backTrack2(ans, n, 0, 0, new String());
        return ans;

    }

    private void backTrack2(List<String> ans, int n, int left, int right, String tempStr) {
        if (left == n && right == n) {
            ans.add(tempStr);
        } else {
            if (left < n) {
                backTrack2(ans, n, left + 1, right, tempStr + "(");
            }
            if (right < left) {
                backTrack2(ans, n, left, right + 1, tempStr + ")");
            }
        }
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
