/*
 * @lc app=leetcode.cn id=219 lang=golang
 *
 * [219] 存在重复元素 II
 */

// @lc code=start
package main

func containsNearbyDuplicate(nums []int, k int) bool {
	return newFunction23(nums, k)
}

/*
	57/57 cases passed (96 ms)
	Your runtime beats 76.98 % of golang submissions
	Your memory usage beats 46.35 % of golang submissions (11.8 MB)
*/
func newFunction23(nums []int, k int) bool {
	data := map[int]int{}
	for i, num := range nums {
		if p, ok := data[num]; ok && i-p <= k {
			return true
		}
		data[num] = i
	}
	return false
}

// @lc code=end
