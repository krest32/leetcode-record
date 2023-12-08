/*
 * @lc app=leetcode.cn id=209 lang=golang
 *
 * [209] 长度最小的子数组
 */

package main

import "math"

// @lc code=start
func minSubArrayLen(target int, nums []int) int {
	return newFunction24(nums, target)

}

/*
	21/21 cases passed (28 ms)
	Your runtime beats 79.58 % of golang submissions
	Your memory usage beats 62.06 % of golang submissions (8.3 MB)
*/
func newFunction24(nums []int, target int) int {
	n := len(nums)
	if n == 0 {
		return 0
	}
	ans := math.MaxInt32
	left, right := 0, 0
	sum := 0
	var min = func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	for right < n {
		sum += nums[right]
		for sum >= target {
			ans = min(ans, right-left+1)
			sum -= nums[left]
			left++
		}
		right++
	}
	if ans == math.MaxInt32 {
		return 0
	}
	return ans
}

// @lc code=end
