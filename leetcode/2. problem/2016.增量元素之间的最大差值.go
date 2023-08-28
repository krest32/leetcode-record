/*
 * @lc app=leetcode.cn id=2016 lang=golang
 *
 * [2016] 增量元素之间的最大差值
 */
package main

// @lc code=start
func maximumDifference(nums []int) int {
	length := len(nums)
	dp := make([]int, length)
	dp[0] = nums[0]
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
		dp[i] = min(dp[i-1], nums[i])
		ans = max(ans, nums[i]-dp[i-1])
	}
	if ans == 0 {
		return -1
	}
	return ans
}

// @lc code=end
