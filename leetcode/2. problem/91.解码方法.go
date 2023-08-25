/*
 * @lc app=leetcode.cn id=91 lang=golang
 *
 * [91] 解码方法
 */
package main

// @lc code=start
func numDecodings(s string) int {
	// return newFunction4(s)

	return func2(s)
}

func func2(str string) int {
	n := len(str)
	dp := make([]int, n+1)
	dp[0] = 1
	for i := 1; i <= n; i++ {
		if str[i-1] != '0' {
			dp[i] += dp[i-1]
		}

		if i > 1 && str[i-2] != '0' && ((str[i-2]-'0')*10+(str[i-1]-'0') <= 26) {
			dp[i] += dp[i-2]
		}
	}
	return dp[n]
}

// 269/269 cases passed (0 ms)
// Your runtime beats 100 % of golang submissions
// Your memory usage beats 71.33 % of golang submissions (1.9 MB)
func newFunction4(s string) int {
	n := len(s)
	dp := make([]int, n+1)
	dp[0] = 1
	for i := 1; i <= n; i++ {
		if s[i-1] != '0' {
			dp[i] += dp[i-1]
		}
		if i > 1 && s[i-2] != '0' && ((s[i-2]-'0')*10+(s[i-1]-'0') <= 26) {
			dp[i] += dp[i-2]
		}
	}
	return dp[n]
}

// @lc code=end
