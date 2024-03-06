import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        // 模拟
        return extracted(s);

        // rest
        // return test(s);
    }

    /**
     * 106/106 cases passed (94 ms)
     * Your runtime beats 41.45 % of java submissions
     * Your memory usage beats 60.54 % of java submissions (42.1 MB)
     * 
     * @param s
     * @return
     */
    private String test(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() == s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }

    private String extracted(String s) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                top--;
            } else {
                stack.append(ch);
                top++;
            }
        }
        return stack.toString();
    }
}
// @lc code=end
