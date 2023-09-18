/*
 * @lc app=leetcode.cn id=416 lang=golang
 *
 * [416] 分割等和子集
 */

package main

// @lc code=start
func canPartition(nums []int) bool {
	n := len(nums)
	if n < 2 {
		return false
	}
	sum := 0
	for _, v := range nums {
		sum += v
	}
	if sum%2 != 0 {
		return false
	}

	target := sum / 2
	dp := make([][]bool, n+1)
	for i := 0; i <= n; i++ {
		dp[i] = make([]bool, target+1)
	}
	for i := 1; i <= n; i++ {
		v := nums[i-1]
		for j := 0; j <= target; j++ {
			dp[i][j] = dp[i-1][j]
			if j == v {
				dp[i][j] = true
			}
			if v < j {
				dp[i][j] = dp[i][j] || dp[i-1][j-v]
			}
		}
	}
	return dp[n][target]
}

// @lc code=end
