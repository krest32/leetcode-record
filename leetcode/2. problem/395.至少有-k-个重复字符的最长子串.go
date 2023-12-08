/*
 * @lc app=leetcode.cn id=395 lang=golang
 *
 * [395] 至少有 K 个重复字符的最长子串
 */

package main

// @lc code=start
func longestSubstring(s string, k int) int {
	charNum := make(map[rune]int)
	// 计算每个字符的数量
	for _, v := range s {
		charNum[v]++
	}
	var split []int
	// 记录每个每个点的索引
	for idx, v := range s {
		if charNum[v] < k {
			split = append(split, idx)
		}
	}
	if len(split) == 0 {
		return len(s)
	}
	split = append(split, len(s))
	reslut, left := 0, 0
	for _, v := range split {
		if v-left+1 <= reslut {
			continue
		}
		reslut = max1(reslut, longestSubstring(s[left:v], k))
		left = v + 1
	}
	return reslut

}

func max1(x, y int) int {
	if x > y {
		return x
	}
	return y
}

// @lc code=end
