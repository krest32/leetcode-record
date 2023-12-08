/*
 * @lc app=leetcode.cn id=118 lang=golang
 *
 * [118] 杨辉三角
 */

package main

// @lc code=start
func generate(numRows int) [][]int {
	ans := make([][]int, numRows)
	for i := range ans {
		ans[i] = make([]int, i+1)
		ans[i][0] = 1
		ans[i][i] = 1
		for j := 1; j < i; j++ {
			ans[i][j] = ans[i-1][j] + ans[i-1][j-1]
		}
	}
	return ans
}

// @lc code=end
