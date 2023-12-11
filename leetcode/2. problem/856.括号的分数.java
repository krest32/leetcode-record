import java.util.Stack;

/*
 * @lc app=leetcode.cn id=856 lang=java
 *
 * [856] 括号的分数
 */

// @lc code=start
class Solution {
    public int scoreOfParentheses(String s) {
        // 使用栈记录括号的深度
        // return extracted(s);

        // 1
        return test(s);
    }

    private int test(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else {
                
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + Math.max(2 * a, 1));
            }
        }
        return stack.pop();
    }

    /**
     * 86/86 cases passed (1 ms)
     * Your runtime beats 42 % of java submissions
     * Your memory usage beats 79.85 % of java submissions (38.7 MB)
     * 
     * @param s
     * @return
     */
    private int extracted(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }

        }
        return stack.pop();
    }
}
// @lc code=end
