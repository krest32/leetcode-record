/*
 * @lc app=leetcode.cn id=1024 lang=golang
 *
 * [1024] 视频拼接
 */
package main

import "math"

// @lc code=start
func videoStitching(clips [][]int, time int) int {
	const inf = math.MaxInt64 - 1
	dp := make([]int, time+1)
	for i := range dp {
		dp[i] = inf
	}
	dp[0] = 0
	for i := 1; i <= time; i++ {
		for _, c := range clips {
			l, r := c[0], c[1]
			if l < i && i <= r && dp[l]+1 < dp[i] {
				dp[i] = dp[l] + 1
			}
		}
	}
	if dp[time] == inf {
		return -1
	}
	return dp[time]
}

// @lc code=end
