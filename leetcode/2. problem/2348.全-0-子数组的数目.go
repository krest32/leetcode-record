/*
 * @lc app=leetcode.cn id=2348 lang=golang
 *
 * [2348] 全 0 子数组的数目
 */
package main

// @lc code=start
func zeroFilledSubarray(nums []int) int64 {
	n := len(nums)
	dp := make([]int64, n)
	if nums[0] == 0 {
		dp[0] = 1
	} else {
		dp[0] = 0
	}
	ans := dp[0]
	for i := 1; i < n; i++ {
		temp := nums[i]
		if temp != 0 {
			dp[i] = 0
		} else {
			dp[i] = dp[i-1] + 1
		}
		ans += dp[i]
	}
	return ans
}

// @lc code=end
