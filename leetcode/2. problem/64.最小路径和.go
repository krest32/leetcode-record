/*
 * @lc app=leetcode.cn id=64 lang=golang
 *
 * [64] 最小路径和
 */
package main

// @lc code=start
func minPathSum(grid [][]int) int {
	return newFunction2(grid)

}

/*
61/61 cases passed (8 ms)
Your runtime beats 61.8 % of golang submissions
Your memory usage beats 47.38 % of golang submissions (4.2 MB)
*/
func newFunction2(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	dp := make([][]int, m)
	var compare = func(i, j int) int {
		if i > j {
			return j
		} else {
			return i
		}
	}
	for i := range dp {
		dp[i] = make([]int, n)
	}
	dp[0][0] = grid[0][0]
	for i := 1; i < m; i++ {
		dp[i][0] = dp[i-1][0] + grid[i][0]
	}

	for j := 1; j < n; j++ {
		dp[0][j] = dp[0][j-1] + grid[0][j]
	}

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[i][j] = compare(dp[i-1][j]+grid[i][j], dp[i][j-1]+grid[i][j])
		}
	}
	return dp[m-1][n-1]
}

// @lc code=end
