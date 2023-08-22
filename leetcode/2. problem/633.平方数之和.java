/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        // 二分查找法
        // return extracted(c);

        // test
        return test(c);
    }

    private boolean test(int c) {
        long left = 0, right = (long) Math.sqrt(c);
        while (left <= right) {
            long ans = left * left + right * right;
            if (ans == c) {
                return true;
            } else if (ans < c) {
                left++;

            } else {
                right--;
            }
        }
        return false;
    }

    /**
     * 127/127 cases passed (3 ms)
     * Your runtime beats 86.31 % of java submissions
     * Your memory usage beats 90.72 % of java submissions (38.1 MB)
     * 
     * @param c
     * @return
     */
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
