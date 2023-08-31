/*
 * @lc app=leetcode.cn id=674 lang=golang
 *
 * [674] 最长连续递增序列
 */
package main

// @lc code=start
func findLengthOfLCIS(nums []int) int {
	return newFunction18(nums)

}

// 35/35 cases passed (4 ms)
// Your runtime beats 95.59 % of golang submissions
// Your memory usage beats 28.26 % of golang submissions (4.4 MB)
func newFunction18(nums []int) int {
	ans := 1
	n := len(nums)
	dp := make([]int, n)
	for i := range dp {
		dp[i] = 1
	}
	for i := 1; i < n; i++ {
		if nums[i] > nums[i-1] {
			dp[i] = dp[i-1] + 1
		}
		if dp[i] > ans {
			ans = dp[i]
		}
	}
	return ans
}

// @lc code=end
