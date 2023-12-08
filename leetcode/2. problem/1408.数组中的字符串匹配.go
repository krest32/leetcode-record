/*
 * @lc app=leetcode.cn id=1408 lang=golang
 *
 * [1408] 数组中的字符串匹配
 */

package main

import "strings"

// @lc code=start
func stringMatching(words []string) []string {
	var ans []string
	for i, x := range words {
		for j, y := range words {
			if i != j && strings.Contains(y, x) {
				ans = append(ans, x)
				break
			}
		}
	}
	return ans
}

// @lc code=end
