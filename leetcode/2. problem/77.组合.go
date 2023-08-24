/*
 * @lc app=leetcode.cn id=77 lang=golang
 *
 * [77] 组合
 */
package main

// @lc code=start
func combine(n int, k int) [][]int {
	var ans [][]int
	var nums []int
	for i := 1; i <= n; i++ {
		nums = append(nums, i)
	}
	visited := make([]bool, n)
	var comb []int
	var dfs func(idx int)
	dfs = func(idx int) {
		if len(comb) == k {
			ans = append(ans, append([]int(nil), comb...))
		} else {
			for i := idx; i < len(nums); i++ {
				if !visited[i] {
					visited[i] = true
					comb = append(comb, nums[i])
					dfs(i + 1)
					comb = comb[:len(comb)-1]
					visited[i] = false
				}

			}
		}
	}
	dfs(0)
	return ans

}

// @lc code=end
