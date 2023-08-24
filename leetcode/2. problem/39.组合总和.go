/*
 * @lc app=leetcode.cn id=39 lang=golang
 *
 * [39] 组合总和
 */

// @lc code=start
package main

func combinationSum(candidates []int, target int) [][]int {
	// 二维数组中添加元素
	// return newFunction(candidates, target)

	// test
	return test(candidates, target)

}

func test(candidates []int, target int) [][]int {
	var ans [][]int
	var dfs func(target, idx int, comb []int)

	dfs = func(target, idx int, comb []int) {
		if target == 0 {
			ans = append(ans, append([]int(nil), comb...))
		} else {
			for i := idx; i < len(candidates); i++ {
				if candidates[i] <= target {
					comb = append(comb, candidates[i])
					// fmt.Println(i, comb)
					dfs(target-candidates[i], i, comb)
					comb = comb[:len(comb)-1]
				}
			}
		}
	}

	dfs(target, 0, []int{})
	return ans
}

func newFunction(candidates []int, target int) [][]int {
	var ans [][]int
	comb := []int{}
	var dfs func(target, idx int)
	dfs = func(target, idx int) {
		if idx == len(candidates) {
			return
		}
		if target == 0 {

			ans = append(ans, append([]int(nil), comb...))
			return
		}
		dfs(target, idx+1)

		if target-candidates[idx] >= 0 {
			comb = append(comb, candidates[idx])
			dfs(target-candidates[idx], idx)
			comb = comb[:len(comb)-1]
		}
	}
	dfs(target, 0)
	return ans
}

// @lc code=end
