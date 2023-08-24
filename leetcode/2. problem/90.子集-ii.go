/*
 * @lc app=leetcode.cn id=90 lang=golang
 *
 * [90] 子集 II
 */
package main

import "sort"

// @lc code=start
func subsetsWithDup(nums []int) [][]int {
	var ans [][]int
	var comb []int
	var dfs func(idx int)
	dfs = func(idx int) {
		ans = append(ans, append([]int(nil), comb...))
		for i := idx; i < len(nums); i++ {
			//
			if i > 0 && i != idx && nums[i] == nums[i-1] {
				continue
			}
			comb = append(comb, nums[i])
			dfs(i + 1)
			comb = comb[:len(comb)-1]
		}
	}
	sort.Slice(nums, func(i, j int) bool {
		return nums[i]-nums[j] < 0
	})
	dfs(0)
	return ans
}

// @lc code=end
