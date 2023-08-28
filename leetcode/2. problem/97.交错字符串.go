/*
 * @lc app=leetcode.cn id=97 lang=golang
 *
 * [97] 交错字符串
 */
package main

// @lc code=start
func isInterleave(s1 string, s2 string, s3 string) bool {
	// 创建 dp 数组
	return newFunction7(s1, s2, s3)

}

// 106/106 cases passed (0 ms)
// Your runtime beats 100 % of golang submissions
// Your memory usage beats 71.02 % of golang submissions (2 MB)
func newFunction7(s1 string, s2 string, s3 string) bool {
	len1, len2, len3 := len(s1), len(s2), len(s3)
	if len1+len2 != len3 {
		return false
	}

	dp := make([][]bool, len1+1)
	for i := 0; i < len1+1; i++ {
		dp[i] = make([]bool, len2+1)
	}
	dp[0][0] = true
	for i := 0; i <= len1; i++ {
		for j := 0; j <= len2; j++ {
			idx := i + j - 1
			if i > 0 {
				dp[i][j] = dp[i][j] || (dp[i-1][j] && s1[i-1] == s3[idx])
			}
			if j > 0 {
				dp[i][j] = dp[i][j] || (dp[i][j-1] && s2[j-1] == s3[idx])
			}
		}
	}
	return dp[len1][len2]
}

// @lc code=end
