/*
 * @lc app=leetcode.cn id=152 lang=golang
 *
 * [152] 乘积最大子数组
 */
package main

// @lc code=start
func maxProduct(nums []int) int {
	return newFunction12(nums)

}

// 190/190 cases passed (4 ms)
// Your runtime beats 94.04 % of golang submissions
// Your memory usage beats 35.37 % of golang submissions (3.8 MB)
func newFunction12(nums []int) int {
	var max = func(i, j int) int {
		if i > j {
			return i
		}
		return j
	}
	var min = func(i, j int) int {
		if i < j {
			return i
		}
		return j
	}
	lenghth := len(nums)
	maxDp := make([]int, lenghth)
	minDp := make([]int, lenghth)
	maxDp[0] = nums[0]
	minDp[0] = nums[0]
	for i := 1; i < lenghth; i++ {
		maxDp[i] = max(minDp[i-1]*nums[i], max(maxDp[i-1]*nums[i], nums[i]))
		minDp[i] = min(minDp[i-1]*nums[i], min(maxDp[i-1]*nums[i], nums[i]))
	}
	ans := maxDp[0]
	for i := 1; i < lenghth; i++ {
		ans = max(ans, maxDp[i])
	}
	return ans
}

// @lc code=end
