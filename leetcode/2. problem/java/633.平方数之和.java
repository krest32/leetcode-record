/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        // 二分查找法
        return extracted(c);
    }

    private boolean extracted(int c) {
        long right = (long) Math.sqrt(c);
        Long left = 0l;
        while (left <= right) {
            long temp = left * left + right * right;
            if (temp == c) {
                return true;
            } else if (temp > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
// @lc code=end
