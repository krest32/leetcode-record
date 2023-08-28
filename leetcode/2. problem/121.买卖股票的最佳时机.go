/*
 * @lc app=leetcode.cn id=121 lang=golang
 *
 * [121] 买卖股票的最佳时机
 */
package main

// @lc code=start
func maxProfit(prices []int) int {
	length := len(prices)
	if length == 1 {
		return 0
	}
	// dp[i] 记录过往时间i，股票的最低价
	dp := make([]int, length)
	dp[0] = prices[0]
	ans := 0
	var min = func(i, j int) int {
		if i > j {
			return j
		} else {
			return i
		}
	}
	var max = func(i, j int) int {
		if i > j {
			return i
		} else {
			return j
		}
	}
	for i := 1; i < length; i++ {
		dp[i] = min(dp[i-1], prices[i])
		ans = max(ans, prices[i]-dp[i])
	}
	return ans

}

// @lc code=end
