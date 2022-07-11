/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	// 暴力枚举
	// return method1(nums, target)

	// Map
	return method2(nums, target)
}

func method1(nums []int, target int) []int {
	for i, num := range nums {
		for j := i + 1; j < len(nums); j++ {
			if num+nums[j] == target {
				return []int{i, j}
			}
		}
	}
	return nil
}

func method2(nums []int, target int) []int {
	data := map[int]int{}
	for i, num := range nums {
		if p, ok := data[target-num]; ok {
			return []int{p, i}
		}
		data[num] = i
	}
	return nil
}

// @lc code=end

