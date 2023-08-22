import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    private static final String List = null;

    public String reverseWords(String s) {
        // return extracted(s);

        // test
        return test(s);
    }

    private String test(String s) {
        String[] strs = s.trim().split(" ");
        List<String> list = new ArrayList<>();
        for (String str : strs) {
            if (str.indexOf(" ") >= 0 || str.indexOf(' ') >= 0) {
                continue;
            }
            list.add(str);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i != 0) {
                ans.append(list.get(i) + " ");
            } else {
                ans.append(list.get(i));
            }
        }
        return ans.toString();
    }

    /**
     * 58/58 cases passed (7 ms)
     * Your runtime beats 51.53 % of java submissions
     * Your memory usage beats 42.69 % of java submissions (41.4 MB)
     * 
     * @param s
     * @return
     */
    private String extracted(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder ret = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].indexOf(" ") >= 0 || str[i].indexOf(' ') >= 0) {
                continue;
            }
            if (str[i].length() > 0) {
                if (i != 0) {
                    ret.append(str[i] + " ");
                } else {
                    ret.append(str[i]);
                }
            }
        }
        return ret.toString();
    }
}
// @lc code=end
