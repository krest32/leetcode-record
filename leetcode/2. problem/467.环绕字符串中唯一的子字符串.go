/*
 * @lc app=leetcode.cn id=467 lang=golang
 *
 * [467] 环绕字符串中唯一的子字符串
 */
package main

// @lc code=start
func findSubstringInWraproundString(p string) int {
	return newFunction14(p)
}

// 82/82 cases passed (0 ms)
// Your runtime beats 100 % of golang submissions
// Your memory usage beats 70.83 % of golang submissions (2.9 MB)
func newFunction14(p string) int {
	dp := make([]int, 26)
	// 两个变量记录上一个字符的数量、以上一个字符结尾的字符串数量
	lastChar := -1
	max := 0
	for _, ch := range p {
		curChar := int(ch - 'a')
		if lastChar+1 == curChar || (lastChar == 25 && ch-'a' == 0) {
			max += 1
		} else {
			max = 1
		}
		if max > dp[curChar] {
			dp[curChar] = max
		}
		lastChar = curChar
	}
	sum := 0
	for _, v := range dp {
		sum += v
	}
	return sum
}

// @lc code=end
