/*
 * @lc app=leetcode.cn id=413 lang=java
 *
 * [413] 等差数列划分
 */

// @lc code=start

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        // 动态规划
        // return extracted(A);

        // test
        return test(A);
    }

    private int test(int[] a) {
        int len = a.length;
        int[] dp = new int[len];
        int sum = 0;
        for (int i = 2; i < len; i++) {
            if (a[i - 1] - a[i - 2] == a[i] - a[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }

    /**
     * 15/15 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 66.54 % of java submissions (39.2 MB)
     * 
     * @param A
     * @return
     */
    private int extracted(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }
}

// @lc code=end
