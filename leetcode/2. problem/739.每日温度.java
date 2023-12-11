import java.util.Stack;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 使用栈
        // return extracted(temperatures);

        // 暴力
        // return extracted2(temperatures);

        return test(temperatures);
    }

    private int[] test(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < temp) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * Your runtime beats 10.26 % of java submissions
     * Your memory usage beats 74.74 % of java submissions (50.8 MB)
     * 
     * @param temperatures
     * @return
     */
    private int[] extracted2(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int cur = temperatures[i];
            int idx = 1;
            for (int j = i + 1; j < len; j++) {
                int next = temperatures[j];
                if (next > cur) {
                    ans[i] = idx;
                    break;
                }
                idx++;
            }
        }
        return ans;
    }

    /**
     * 48/48 cases passed (166 ms)
     * Your runtime beats 32.84 % of java submissions
     * Your memory usage beats 79.14 % of java submissions (53.9 MB)
     * 
     * @param temperatures
     * @return
     */
    private int[] extracted(int[] temperatures) {
        int len = temperatures.length;
        // ans 中的默认值是0
        int[] ans = new int[len];
        // stack 内部温度递增，记录的是温度在数组中的下标
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                // 更新 ans 中数组下标的数据
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
// @lc code=end
