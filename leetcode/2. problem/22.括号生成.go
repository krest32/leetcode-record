/*
 * @lc app=leetcode.cn id=22 lang=golang
 *
 * [22] 括号生成
 */

// @lc code=start
package main

func generateParenthesis(n int) []string {
	ans := []string{}
	path := ""
	var dfs func(int, int, int, string)
	dfs = func(i, lc, rc int, path string) {
		if lc == n && rc == n {
			ans = append(ans, string(path))
		} else {
			if lc < n {
				dfs(n, lc+1, rc, path+"(")
			}
			if rc < lc {
				dfs(n, lc, rc+1, path+")")
			}
		}
	}
	dfs(0, 0, 0, path)
	return ans
}

// @lc code=end
