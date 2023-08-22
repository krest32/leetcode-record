/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
package main

func twoSum(nums []int, target int) []int {
	dataMap := map[int]int{}
	for i, x := range nums {
		if p, ok := dataMap[target-x]; ok {
			return []int{p, i}
		}
		dataMap[x] = i
	}
	return nil
}

// @lc code=end
