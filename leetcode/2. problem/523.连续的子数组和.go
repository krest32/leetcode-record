/*
 * @lc app=leetcode.cn id=523 lang=golang
 *
 * [523] 连续的子数组和
 */
package main

// @lc code=start
func checkSubarraySum(nums []int, k int) bool {
	return newFunction16(nums, k)
}

// 99/99 cases passed (160 ms)
// Your runtime beats 40 % of golang submissions
// Your memory usage beats 27.82 % of golang submissions (13.1 MB)
func newFunction16(nums []int, k int) bool {
	m := len(nums)
	if m < 2 {
		return false
	}
	// map key 为余数，value为数字的索引
	mp := map[int]int{0: -1}
	remainder := 0
	for i, num := range nums {
		remainder = (remainder + num) % k
		if preIdx, has := mp[remainder]; has {
			if i-preIdx >= 2 {
				return true
			}
		} else {
			mp[remainder] = i
		}
	}
	return false
}

// @lc code=end
