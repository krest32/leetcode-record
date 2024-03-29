import java.util.Stack;

/*
 * @lc app=leetcode.cn id=1006 lang=java
 *
 * [1006] 笨阶乘
 */

// @lc code=start
class Solution {
    public int clumsy(int n) {
        // 栈
        // return extracted(n);

        // test
        return test(n);
    }

    private int test(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        n--;
        int index = 0;
        while (n > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * n);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / n);
            } else if (index % 4 == 2) {
                stack.push(n);
            } else {
                stack.push(-n);
            }
            index++;
            n--;
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    /**
     * 84/84 cases passed (23 ms)
     * Your runtime beats 10.87 % of java submissions
     * Your memory usage beats 40.58 % of java submissions (40.6 MB)
     * 
     * @param n
     * @return
     */
    private int extracted(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        n--;
        // 控制加减乘除
        int index = 0;
        while (n > 0) {
            // 进行 *
            if (index % 4 == 0) {
                stack.push(stack.pop() * n);
                // 进行 /
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / n);
                // 进行 +
            } else if (index % 4 == 2) {
                stack.push(n);
                // 进行 -
            } else {
                stack.push(-n);
            }
            index++;
            n--;
        }
        int sum = 0;
        // 将最终计算的结果进行累加
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
// @lc code=end
