/*
 * @lc app=leetcode.cn id=3 lang=golang
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
package main

func lengthOfLongestSubstring(s string) int {
	ans := 0
	var max = func(x, y int) int {
		if x <= y {
			return y
		} else {
			return x
		}
	}
	data := map[int32]int{}
	left := 0
	for i, char := range s {
		p, ok := data[char]
		if ok {
			left = max(p+1, left)
		}
		ans = max(ans, i-left+1)
		data[char] = i
	}

	return ans
}

// @lc code=end
