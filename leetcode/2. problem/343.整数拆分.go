/*
 * @lc app=leetcode.cn id=343 lang=golang
 *
 * [343] 整数拆分
 */
package main

// @lc code=start
func integerBreak(n int) int {
	return newFunction21(n)
}

// 50/50 cases passed (0 ms)
// Your runtime beats 100 % of golang submissions
// Your memory usage beats 48.86 % of golang submissions (1.8 MB)
func newFunction21(n int) int {
	var max = func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}
	dp := make([]int, n+1)
	for i := 2; i <= n; i++ {
		for j := 0; j < i; j++ {
			dp[i] = max(dp[i], max(dp[i-j]*j, (i-j)*j))
		}
	}
	return dp[n]
}

// @lc code=end
