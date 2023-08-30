/*
 * @lc app=leetcode.cn id=221 lang=golang
 *
 * [221] 最大正方形
 */
package main

// @lc code=start
func maximalSquare(matrix [][]byte) int {
	var min = func(i, j int) int {
		if i > j {
			return j
		}
		return i
	}
	var max = func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}
	row, colunm := len(matrix), len(matrix[0])
	maxSide := 0
	dp := make([][]int, row)
	for i := 0; i < row; i++ {
		dp[i] = make([]int, colunm)
	}
	for i := 0; i < row; i++ {
		for j := 0; j < colunm; j++ {
			if matrix[i][j] == '1' {
				if i == 0 || j == 0 {
					dp[i][j] = 1
				} else {
					dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1])) + 1
				}
				maxSide = max(maxSide, dp[i][j])
			}
		}
	}

	return maxSide * maxSide
}

// @lc code=end
