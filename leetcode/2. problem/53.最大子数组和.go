/*
 * @lc app=leetcode.cn id=53 lang=golang
 *
 * [53] 最大子数组和
 */
package main

// @lc code=start
func maxSubArray(nums []int) int {
	max := nums[0]
	var compare func(num1, num2 int) int
	compare = func(num1, num2 int) int {
		if num1 > num2 {
			return num1
		} else {
			return num2
		}
	}
	dp := make([]int, len(nums))
	dp[0] = nums[0]
	for i := 1; i < len(nums); i++ {
		dp[i] = compare(nums[i], dp[i-1]+nums[i])
		max = compare(dp[i], max)
	}
	return max
}

// @lc code=end
