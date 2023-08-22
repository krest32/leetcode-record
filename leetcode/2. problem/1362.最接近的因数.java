/*
 * @lc app=leetcode.cn id=1362 lang=java
 *
 * [1362] 最接近的因数
 */

// @lc code=start
class Solution {
    public int[] closestDivisors(int num) {
        return extracted(num);
    }

    /**
     * 113/113 cases passed (2 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 91.8 % of java submissions (38.9 MB)
     * 
     * @param num
     * @return
     */
    private int[] extracted(int num) {
        // 先确认目标值
        int divisor = num == 1 ? num + 1 : num + 2;
        // 得到平方根
        int i = (int) Math.sqrt(divisor);
        while (divisor % i > 1) {
            i--;
        }
        return new int[] { i, divisor / i };
    }
}
// @lc code=end
