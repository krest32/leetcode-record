/*
 * @lc app=leetcode.cn id=198 lang=golang
 *
 * [198] 打家劫舍
 */
package main

// @lc code=start
func rob(nums []int) int {
	length := len(nums)
	if nums == nil || length == 0 {
		return 0
	}
	if length == 1 {
		return nums[0]
	}

	var max = func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}
	dp := make([]int, length+1)
	dp[0] = nums[0]
	dp[1] = max(dp[0], nums[1])
	for i := 2; i < length; i++ {
		dp[i] = max(dp[i-2]+nums[i], dp[i-1])
	}
	return dp[length-1]
}

// @lc code=end
