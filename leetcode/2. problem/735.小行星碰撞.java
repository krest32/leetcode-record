/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 行星碰撞
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        return method1(asteroids);
    }

    /**
     * 275/275 cases passed (14 ms)
     * Your runtime beats 11.44 % of java submissions
     * Your memory usage beats 46.78 % of java submissions (43.1 MB)
     * 
     * @param asteroids
     * @return
     */
    private int[] method1(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean alive = true;
            while (alive
                    && !stack.isEmpty()
                    && stack.peek() > 0
                    && asteroids[i] < 0) {
                alive = stack.peek() < -asteroids[i];
                if (stack.peek() <= -asteroids[i]) {
                    stack.pop();
                }
            }
            if (alive) {
                stack.push(asteroids[i]);
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
// @lc code=end
