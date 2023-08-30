/*
 * @lc app=leetcode.cn id=509 lang=golang
 *
 * [509] 斐波那契数
 */
package main

// @lc code=start
func fib(n int) int {
	return newFunction15(n)
}

// 31/31 cases passed (0 ms)
// Your runtime beats 100 % of golang submissions
// Your memory usage beats 18.47 % of golang submissions (1.8 MB)
func newFunction15(n int) int {
	dp := make([]int, n+1)
	if n == 0 {
		return 0
	}
	if n == 1 {
		return 1
	}
	dp[0], dp[1] = 0, 1
	for i := 2; i <= n; i++ {
		dp[i] = dp[i-1] + dp[i-2]
	}
	return dp[n]
}

// @lc code=end
