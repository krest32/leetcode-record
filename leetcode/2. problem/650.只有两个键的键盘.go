/*
 * @lc app=leetcode.cn id=650 lang=golang
 *
 * [650] 只有两个键的键盘
 */

package main

// @lc code=start
func minSteps(n int) int {
	dp := make([]int, n+1)
	var min = func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}
	for i := 2; i <= n; i++ {
		dp[i] = i
		for j := 1; j*j <= i; j++ {
			if i%j == 0 {
				dp[i] = min(dp[i], dp[j]+i/j)
				dp[i] = min(dp[i], dp[i/j]+j)
			}
		}
	}
	return dp[n]
}

// @lc code=end
