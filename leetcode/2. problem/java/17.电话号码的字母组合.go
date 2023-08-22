/*
 * @lc app=leetcode.cn id=17 lang=golang
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
package main

import "fmt"

var phoneMap = map[string]string{
	"2": "abc",
	"3": "def",
	"4": "ghi",
	"5": "jkl",
	"6": "mno",
	"7": "pqrs",
	"8": "tuv",
	"9": "wxyz",
}
var combs []string

func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}
	combs = []string{}
	backtrack(digits, 0, "")
	return combs
}

func backtrack(digits string, idx int, comb string) {
	if idx == len(digits) {
		combs = append(combs, comb)
	} else {
		digit := string(digits[idx])
		letters := phoneMap[digit]
		lettersCount := len(letters)
		for i := 0; i < lettersCount; i++ {
			fmt.Println(comb)
			backtrack(digits, idx+1, comb+string(letters[i]))
		}
	}
}

// @lc code=end
