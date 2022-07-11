/*
 * @lc app=leetcode.cn id=13 lang=golang
 *
 * [13] 罗马数字转整数
 */

// @lc code=start

var data = map[byte]int{'I': 1, 'V': 5, 'X': 10,
	'L': 50, 'C': 100, 'D': 500, 'M': 1000}

func romanToInt(s string) int {
	length := len(s)
	ans := 0
	for i := range s {
		value := data[s[i]]
		if i < length-1 && value < data[s[i+1]] {
			ans -= value
		} else {
			ans += value
		}
	}
	return ans
}

// @lc code=end

