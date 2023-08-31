/*
 * @lc app=leetcode.cn id=1035 lang=golang
 *
 * [1035] 不相交的线
 */
package main

// @lc code=start
func maxUncrossedLines(nums1 []int, nums2 []int) int {
	return newFunction19(nums1, nums2)
}

// 74/74 cases passed (0 ms)
// Your runtime beats 100 % of golang submissions
// Your memory usage beats 87.4 % of golang submissions (6.3 MB)
func newFunction19(nums1 []int, nums2 []int) int {
	l1, l2 := len(nums1), len(nums2)
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
		num1 := nums1[i-1]
		for j := 1; j <= l2; j++ {
			num2 := nums2[j-1]
			if num1 == num2 {
				dp[i][j] = dp[i-1][j-1] + 1
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1])
			}
		}
	}
	return dp[l1][l2]
}

// @lc code=end
