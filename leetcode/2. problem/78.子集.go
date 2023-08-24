/*
 * @lc app=leetcode.cn id=78 lang=golang
 *
 * [78] 子集
 */

package main

// @lc code=start
func subsets(nums []int) [][]int {
	var ans [][]int
	var comb []int
	var dfs func(idx int)
	dfs = func(idx int) {
		ans = append(ans, append([]int(nil), comb...))
		for i := idx; i < len(nums); i++ {
			comb = append(comb, nums[i])
			dfs(i + 1)
			comb = comb[:len(comb)-1]
		}
	}
	dfs(0)
	return ans
}

// @lc code=end
