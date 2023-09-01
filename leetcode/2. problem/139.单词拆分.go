/*
 * @lc app=leetcode.cn id=139 lang=golang
 *
 * [139] 单词拆分
 */

package main

// @lc code=start
func wordBreak(s string, wordDict []string) bool {
	n := len(s)
	wordDictSet := make(map[string]bool)
	for _, w := range wordDict {
		wordDictSet[w] = true
	}
	dp := make([]bool, n+1)
	dp[0] = true
	for i := 0; i <= n; i++ {
		for j := 0; j < i; j++ {
			if dp[j] && wordDictSet[s[j:i]] {
				dp[i] = true
			}
		}
	}
	return dp[n]
}

// @lc code=end
