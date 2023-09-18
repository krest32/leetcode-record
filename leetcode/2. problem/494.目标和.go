/*
 * @lc app=leetcode.cn id=494 lang=golang
 *
 * [494] 目标和
 */
package main

// @lc code=start
func findTargetSumWays(nums []int, target int) int {
	return newFunction22(nums, target)

}

// 140/140 cases passed (4 ms)
// Your runtime beats 62.33 % of golang submissions
// Your memory usage beats 23.12 % of golang submissions (6.4 MB)
func newFunction22(nums []int, target int) int {
	n := len(nums)
	sum := 0
	for _, v := range nums {
		sum += v
	}
	diff := sum - target
	if diff < 0 || diff%2 != 0 {
		return 0
	}
	neg := diff / 2
	dp := make([][]int, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]int, neg+1)
	}
	dp[0][0] = 1
	for i := 1; i <= n; i++ {
		val := nums[i-1]
		for j := 0; j <= neg; j++ {
			dp[i][j] = dp[i-1][j]
			if j >= val {
				dp[i][j] += dp[i-1][j-val]
			}
		}
	}
	return dp[n][neg]
}

// @lc code=end
