/*
 * @lc app=leetcode.cn id=63 lang=golang
 *
 * [63] 不同路径 II
 */

package main

import "fmt"

// @lc code=start
func uniquePathsWithObstacles(obstacleGrid [][]int) int {

	return newFunction1(obstacleGrid)
}

/*
41/41 cases passed (4 ms)
Your runtime beats 42.16 % of golang submissions
Your memory usage beats 51.89 % of golang submissions (2.4 MB)
*/
func newFunction1(obstacleGrid [][]int) int {
	m, n := len(obstacleGrid), len(obstacleGrid[0])
	dp := make([][]int, m)

	// 必须先完成dp创建
	for i := range dp {
		dp[i] = make([]int, n)
	}

	// 对数据参数进行判断
	for i := range dp {
		if obstacleGrid[i][0] == 0 {
			dp[i][0] = 1
		} else {
			break
		}
	}

	for j := 0; j < n; j++ {
		if obstacleGrid[0][j] == 0 {
			dp[0][j] = 1
		} else {
			break
		}
	}

	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			fmt.Println(i, j)
			if obstacleGrid[i][j] == 0 {
				dp[i][j] = dp[i][j-1] + dp[i-1][j]
			} else {
				dp[i][j] = 0
			}
		}
	}
	return dp[m-1][n-1]
}

// @lc code=end
