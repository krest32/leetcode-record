/*
 * @lc app=leetcode.cn id=188 lang=golang
 *
 * [188] 买卖股票的最佳时机 IV
 */
package main

// @lc code=start
func maxProfit(k int, prices []int) int {
	return newFunction11(prices, k)
}

// 210/210 cases passed (16 ms)
// Your runtime beats 10.03 % of golang submissions
// Your memory usage beats 13.6 % of golang submissions (11.3 MB)
func newFunction11(prices []int, k int) int {
	length := len(prices)

	// 创建 dp 数组, [天数][次数][是否持有] 0-N 1—Y
	dp := make([][][]int, length)
	for i := 0; i < length; i++ {
		dp[i] = make([][]int, k+1)
		for j := 0; j < k+1; j++ {
			dp[i][j] = make([]int, 2)
		}
	}
	for i := 0; i <= k; i++ {
		dp[0][i][1] = -prices[0]
	}
	var max = func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}
	for i := 1; i < length; i++ {
		for j := 1; j <= k; j++ {
			dp[i][j][0] = max(dp[i-1][j][0], dp[i-1][j][1]+prices[i])
			dp[i][j][1] = max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i])
		}
	}
	return dp[length-1][k][0]
}

// @lc code=end
