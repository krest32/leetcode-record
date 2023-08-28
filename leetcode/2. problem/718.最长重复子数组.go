/*
 * @lc app=leetcode.cn id=718 lang=golang
 *
 * [718] 最长重复子数组
 */

package main

// @lc code=start
func findLength(nums1 []int, nums2 []int) int {
	return newFunction8(nums1, nums2)
}

// 53/53 cases passed (52 ms)
// Your runtime beats 16.54 % of golang submissions
// Your memory usage beats 18.82 % of golang submissions (18.7 MB)
func newFunction8(nums1 []int, nums2 []int) int {
	len1, len2 := len(nums1), len(nums2)
	dp := make([][]int, len1+1)
	for i := 0; i < len1+1; i++ {
		dp[i] = make([]int, len2+1)
	}
	if nums1[0] == nums2[0] {
		dp[0][0] = 1
	}
	ans := 0
	var compare = func(i, j int) int {
		if i > j {
			return i
		} else {
			return j
		}
	}
	for i := 0; i < len1; i++ {
		num1 := nums1[i]
		for j := 0; j < len2; j++ {
			num2 := nums2[j]
			/**
			 * '为了避免重复比较
			 * A[i:] 与 B[j:] 的最长公共前缀为
			 * A[i + 1:] 与 B[j + 1:] 的最长公共前缀的长度加一
			 * dp[i][j] = dp[i + 1][j + 1] + 1
			 */
			if num1 == num2 {
				if i == 0 || j == 0 {
					dp[i][j] = 1

				} else {
					dp[i][j] = dp[i-1][j-1] + 1
				}
			}
			ans = compare(ans, dp[i][j])
		}
	}
	return ans
}

// @lc code=end
