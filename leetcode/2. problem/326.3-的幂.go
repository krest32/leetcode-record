/*
 * @lc app=leetcode.cn id=326 lang=golang
 *
 * [326] 3 的幂
 */

package main

// @lc code=start
func isPowerOfThree(n int) bool {
	if n < 1 {
		return false
	}

	for n%3 == 0 {
		n = n / 3
	}
	if n == 1 {
		return true
	}
	return false
}

// @lc code=end
