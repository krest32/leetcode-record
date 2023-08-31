/*
 * @lc app=leetcode.cn id=1143 lang=golang
 *
 * [1143] 最长公共子序列
 */
package main

// @lc code=start
func longestCommonSubsequence(text1 string, text2 string) int {
	return newFunction20(text1, text2)
}

// 47/47 cases passed (12 ms)
// Your runtime beats 64.92 % of golang submissions
// Your memory usage beats 78.13 % of golang submissions (15.2 MB)
func newFunction20(text1 string, text2 string) int {
	l1, l2 := len(text1), len(text2)
	dp := make([][]int, l1+1)
	for i := 0; i < l1+1; i++ {
		dp[i] = make([]int, l2+1)
	}
	var max = func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}
	for i := 1; i < l1+1; i++ {
		ch1 := int(text1[i-1] - 'a')
		for j := 1; j < l2+1; j++ {
			ch2 := int(text2[j-1] - 'a')
			if ch1 == ch2 {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1])
			}
		}
	}
	return dp[l1][l2]
}

// @lc code=end
