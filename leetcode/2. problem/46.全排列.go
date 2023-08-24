/*
 * @lc app=leetcode.cn id=46 lang=golang
 *
 * [46] 全排列
 */

package main

// @lc code=start
func permute(nums []int) [][]int {
	var ans [][]int
	var comb []int
	visited := make([]bool, len(nums))
	var dfs func()
	dfs = func() {
		if len(comb) == len(nums) {
			ans = append(ans, append([]int(nil), comb...))
		} else {
			for i := 0; i < len(nums); i++ {
				if !visited[i] {
					visited[i] = true
					comb = append(comb, nums[i])
					dfs()
					comb = comb[:len(comb)-1]
					visited[i] = false
				}
			}
		}
	}
	dfs()
	return ans

}

// @lc code=end
