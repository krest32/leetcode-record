/*
 * @lc app=leetcode.cn id=746 lang=golang
 *
 * [746] 使用最小花费爬楼梯
 */
package main

// @lc code=start
func minCostClimbingStairs(cost []int) int {
	// 获取最小值
	// return newFunction6(cost)

	// 测试
	return minCostClimbingStairsTest(cost)

}
func minCostClimbingStairsTest(cost []int) int {
	length := len(cost)
	dp := make([]int, length+1)
	var compare = func(i, j int) int {
		if i > j {
			return j
		} else {
			return i
		}
	}
	dp[0] = 0
	dp[1] = 0
	for i := 2; i <= length; i++ {
		dp[i] = compare(dp[i-2]+cost[i-2], dp[i-1]+cost[i-1])
	}
	return dp[length]
}

func newFunction6(cost []int) int {
	length := len(cost) + 1
	dp := make([]int, length)

	var compare = func(i, j int) int {
		if i > j {
			return j
		} else {
			return i
		}
	}
	dp[0] = 0
	dp[1] = 0
	for i := 2; i <= len(cost); i++ {
		dp[i] = compare(dp[i-2]+cost[i-2], dp[i-1]+cost[i-1])
	}
	return dp[len(cost)]
}

// @lc code=end
