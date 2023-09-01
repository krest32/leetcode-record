/*
 * @lc app=leetcode.cn id=1218 lang=golang
 *
 * [1218] 最长定差子序列
 */

package main

// @lc code=start
func longestSubsequence(arr []int, difference int) int {
	dp := map[int]int{}
	ans := 0
	for _, v := range arr {
		dp[v] = dp[v-difference] + 1
		if dp[v] > ans {
			ans = dp[v]
		}
	}
	return ans
}

// @lc code=end
