/*
 * @lc app=leetcode.cn id=40 lang=golang
 *
 * [40] 组合总和 II
 */

// @lc code=start
package main

import "sort"

func combinationSum2(candidates []int, target int) [][]int {
	sort.Slice(candidates, func(i, j int) bool {
		return candidates[i] < candidates[j]
	})
	var ans [][]int
	var comb []int
	var dfs func(target, idx int)
	dfs = func(target, idx int) {
		if target == 0 {
			ans = append(ans, append([]int(nil), comb...))
		} else {
			for i := idx; i < len(candidates); i++ {
				num := candidates[i]
				if i > 0 && num == candidates[i-1] && i != idx {
					continue
				}
				if num <= target {
					comb = append(comb, num)
					dfs(target-num, i+1)
					comb = comb[:len(comb)-1]
				}
			}
		}
	}
	dfs(target, 0)
	return ans
}

// @lc code=end
