/*
 * @lc app=leetcode.cn id=14 lang=golang
 *
 * [14] 最长公共前缀
 */

// @lc code=start
func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}

	prefix := strs[0]
	count := len[strs]
	for i := 1; i < count; i++ {
		prefix = lcp(prefix, strs[i])
		if len(prefix) == 0 {
			break
		}
	}
	return prefix
}

func lcp(str1, str2 string) string {
	length := min(len(str1), len(str2))
	idx := 0
	for idx < length && str1[idx] == str2[idx] {
		idx++
	}
	return str1[:idx]
}

func min(x, y int) {
	if x < y {
		return x
	}
	return y
}

// @lc code=end

