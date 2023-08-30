/*
 * @lc app=leetcode.cn id=413 lang=golang
 *
 * [413] 等差数列划分
 */

package main

func numberOfArithmeticSlices(nums []int) int {
	return newFunction13(nums)
}

// 15/15 cases passed (4 ms)
// Your runtime beats 22.22 % of golang submissions
// Your memory usage beats 31.94 % of golang submissions (2.1 MB)
func newFunction13(nums []int) int {
	length := len(nums)
	dp := make([]int, length)
	sum := 0
	for i := 2; i < length; i++ {
		if nums[i]-nums[i-1] == nums[i-1]-nums[i-2] {
			dp[i] = dp[i-1] + 1
			sum += dp[i]
		}
	}
	return sum
}

// @lc code=end
