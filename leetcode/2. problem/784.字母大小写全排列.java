import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784]
 */

// @lc code=start
class Solution {
    public List<String> letterCasePermutation(String s) {
        // 模拟 + list动态扩容
        // return extracted(s);

        // 1
        return test(s);
    }

    private List<String> test(String s) {
        List<StringBuilder> list = new ArrayList<>();
        list.add(new StringBuilder());
        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                int len = list.size();
                for (int i = 0; i < len; i++) {
                    list.add(new StringBuilder(list.get(i)));
                    list.get(i).append(Character.toLowerCase(ch));
                    list.get(i + len).append(Character.toUpperCase(ch));
                }
            } else {
                for (StringBuilder tempStr : list) {
                    tempStr.append(ch);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (StringBuilder temp : list) {
            ans.add(temp.toString());
        }
        return ans;
    }

    /**
     * 63/63 cases passed (7 ms)
     * Your runtime beats 26.02 % of java submissions
     * Your memory usage beats 7.74 % of java submissions (42.5 MB)
     * 
     * @param s
     * @return
     */
    private List<String> extracted(String s) {
        List<StringBuilder> ans = new ArrayList<>();
        ans.add(new StringBuilder());
        for (char c : s.toCharArray()) {
            int n = ans.size();
            // 如果当前的字符是字母，执行如下操作
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; i++) {
                    // 对于 ans 进行一次扩容
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n + i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; i++) {
                    ans.get(i).append(c);
                }
            }
        }
        List<String> finals = new ArrayList<>();
        for (StringBuilder sb : ans) {
            finals.add(sb.toString());
        }
        return finals;
    }
}
// @lc code=end
