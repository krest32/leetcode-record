/*
 * @lc app=leetcode.cn id=300 lang=golang
 *
 * [300] 最长递增子序列
 */
package main

// @lc code=start
func lengthOfLIS(nums []int) int {
	var max = func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}
	length := len(nums)
	dp := make([]int, length)
	dp[0] = 1
	ans := 1
	for i := 0; i < length; i++ {
		dp[i] = 1
		for j := 0; j < i; j++ {
			if nums[j] < nums[i] {
				dp[i] = max(dp[j]+1, dp[i])
			}
		}
		ans = max(dp[i], ans)
	}
	return ans

}

// @lc code=end
