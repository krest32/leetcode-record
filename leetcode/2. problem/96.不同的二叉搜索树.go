/*
 * @lc app=leetcode.cn id=96 lang=golang
 *
 * [96] 不同的二叉搜索树
 */
package main

// @lc code=start
func numTrees(n int) int {
	return newFunction5(n)
}

// 19/19 cases passed (0 ms)
// Your runtime beats 100 % of golang submissions
// Your memory usage beats 88.32 % of golang submissions (1.8 MB)
func newFunction5(n int) int {
	dp := make([]int, n+1)
	dp[0] = 1
	dp[1] = 1
	for i := 2; i <= n; i++ {
		for j := 1; j <= i; j++ {
			dp[i] += dp[j-1] * dp[i-j]
		}
	}
	return dp[n]
}

// @lc code=end
