/*
 * @lc app=leetcode.cn id=583 lang=golang
 *
 * [583] 两个字符串的删除操作
 */
package main

// @lc code=start
func minDistance(word1 string, word2 string) int {
	return newFunction17(word1, word2)
}

// 1306/1306 cases passed (0 ms)
// Your runtime beats 100 % of golang submissions
// Your memory usage beats 94.97 % of golang submissions (6.6 MB)
func newFunction17(word1 string, word2 string) int {
	l1, l2 := len(word1), len(word2)
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
	for i := 1; i <= l1; i++ {
		ch1 := int(word1[i-1] - 'a')
		for j := 1; j <= l2; j++ {
			ch2 := int(word2[j-1] - 'a')
			if ch1 == ch2 {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = max(dp[i][j-1], dp[i-1][j])
			}
		}
	}
	return l1 + l2 - 2*dp[l1][l2]
}

// @lc code=end
