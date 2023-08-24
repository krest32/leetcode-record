/*
 * @lc app=leetcode.cn id=47 lang=golang
 *
 * [47] 全排列 II
 */
package main

import "sort"

// @lc code=start
func permuteUnique(nums []int) [][]int {
	var dfs func()
	var ans [][]int
	visited := make([]bool, len(nums))
	sort.Slice(nums, func(i, j int) bool {
		return nums[i]-nums[j] < 0
	})
	var comb []int
	dfs = func() {
		if len(nums) == len(comb) {
			ans = append(ans, append([]int(nil), comb...))
		} else {
			for i := 0; i < len(nums); i++ {
				if i > 0 && nums[i] == nums[i-1] && !visited[i-1] {
					continue
				}
				if !visited[i] {
					visited[i] = true
					comb = append(comb, nums[i])
					dfs()
					comb = comb[:len(nums)-1]
					visited[i] = false
				}
			}
		}
	}
	dfs()
	return ans
}

// @lc code=end
