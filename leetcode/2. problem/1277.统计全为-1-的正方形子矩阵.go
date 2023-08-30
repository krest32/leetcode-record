/*
 * @lc app=leetcode.cn id=1277 lang=golang
 *
 * [1277] 统计全为 1 的正方形子矩阵
 */
package main

// @lc code=start
func countSquares(matrix [][]int) int {
	var min = func(i, j int) int {
		if i > j {
			return j
		}
		return i
	}
	row, colunm := len(matrix), len(matrix[0])
	ans := 0
	dp := make([][]int, row)
	for i := 0; i < row; i++ {
		dp[i] = make([]int, colunm)
	}
	for i := 0; i < row; i++ {
		for j := 0; j < colunm; j++ {
			if matrix[i][j] == 1 {
				if i == 0 || j == 0 {
					dp[i][j] = 1
				} else {
					dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1])) + 1
				}
				ans += dp[i][j]
			}
		}
	}

	return ans
}

// @lc code=end
