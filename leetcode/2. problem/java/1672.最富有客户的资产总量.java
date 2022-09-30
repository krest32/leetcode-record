/*
 * @lc app=leetcode.cn id=1672 lang=java
 *
 * [1672] 最富有客户的资产总量
 */

// @lc code=start
class Solution {
    public int maximumWealth(int[][] accounts) {
        // 模拟
        // return extracted(accounts);

        // test
        return test(accounts);
    }

    private int test(int[][] accounts) {
        int maxSum = 0;
        int rows = accounts.length;
        int colums = accounts[0].length;

        for (int i = 0; i < rows; i++) {
            int sum = 0;
            for (int j = 0; j < colums; j++) {
                sum += accounts[i][j];
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    /**
     * 34/34 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 17.35 % of java submissions (41.2 MB)
     * 
     * @param accounts
     * @return
     */
    private int extracted(int[][] accounts) {
        int summax = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                // 求和
                sum += accounts[i][j];
            }
            // 取最值
            summax = Math.max(summax, sum);
        }
        return summax;
    }
}
// @lc code=end
