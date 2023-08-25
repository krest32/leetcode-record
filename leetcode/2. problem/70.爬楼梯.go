/*
 * @lc app=leetcode.cn id=70 lang=golang
 *
 * [70] 爬楼梯
 */

package main

// @lc code=start
func climbStairs(n int) int {
	return newFunction3(n)
}

/*
45/45 cases passed (0 ms)
Your runtime beats 100 % of golang submissions
Your memory usage beats 41.27 % of golang submissions (1.8 MB)
*/
func newFunction3(n int) int {
	dp := make([]int, n+1)
	dp[1] = 1
	if n < 2 {
		return 1
	}
	dp[2] = 2
	for i := 3; i <= n; i++ {
		dp[i] = dp[i-1] + dp[i-2]
	}
	return dp[n]
}

// @lc code=end
