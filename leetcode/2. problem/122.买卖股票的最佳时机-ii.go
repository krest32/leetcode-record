/*
 * @lc app=leetcode.cn id=122 lang=golang
 *
 * [122] 买卖股票的最佳时机 II
 */
package main

// @lc code=start
func maxProfit(prices []int) int {
	// dp[i][0] 代表不持有股票收益
	// dp[i][1] 代表持有股票收益
	return newFunction9(prices)
}

// 200/200 cases passed (0 ms)
// Your runtime beats 100 % of golang submissions
// Your memory usage beats 10.97 % of golang submissions (4 MB)
func newFunction9(prices []int) int {
	length := len(prices)
	dp := make([][]int, length)
	for i := 0; i < length; i++ {
		dp[i] = make([]int, 2)
	}
	var max = func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}

	dp[0][0] = 0
	dp[0][1] = -prices[0]
	for i := 1; i < length; i++ {
		dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
		dp[i][1] = max(dp[i-1][1], dp[i-1][0]-prices[i])

	}
	return dp[length-1][0]
}

// @lc code=end
