/*
 * @lc app=leetcode.cn id=123 lang=golang
 *
 * [123] 买卖股票的最佳时机 III
 */
package main

// @lc code=start
func maxProfit(prices []int) int {

	return newFunction10(prices)
}

// 214/214 cases passed (152 ms)
// Your runtime beats 21.68 % of golang submissions
// Your memory usage beats 34.22 % of golang submissions (19.5 MB)
func newFunction10(prices []int) int {
	var max = func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}
	length := len(prices)
	dp := make([][]int, length)
	for i := 0; i < length; i++ {
		dp[i] = make([]int, 4)
	}
	/*
	* 定义 4 种状态:
	* 0: 第一次买入,
	* 1: 第一次卖出,
	* 2: 第二次买入,
	* 3: 第二次卖出
	 */
	dp[0][0] = -prices[0]
	dp[0][2] = -prices[0]
	for i := 1; i < length; i++ {
		dp[i][0] = max(dp[i-1][0], -prices[i])
		dp[i][1] = max(dp[i-1][1], dp[i][0]+prices[i])
		dp[i][2] = max(dp[i-1][2], dp[i-1][1]-prices[i])
		dp[i][3] = max(dp[i-1][3], dp[i-1][2]+prices[i])
	}
	return dp[length-1][3]
}

// @lc code=end
