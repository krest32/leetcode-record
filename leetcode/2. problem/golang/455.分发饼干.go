/*
 * @lc app=leetcode.cn id=455 lang=golang
 *
 * [455] 分发饼干
 */

// @lc code=start
func findContentChildren(g []int, s []int) (ans int) {
	return test(g, s)
}

func test(greed, size []int) (ans int) {
	sort.Ints(greed)
	sort.Ints(size)
	n, m := len(greed), len(size)
	for i, j := 0, 0; i < n && j < m; i++ {
		// 如果孩子的胃口大与饼干的size,
		for j < m && greed[i] > size[j] {
			j++
		}
		if j < m {
			ans++
			j++
		}
	}
	return
}
func method(g, s []int) (ans int) {
	sort.Ints(g)
	sort.Ints(s)
	n, m := len(g), len(s)
	for i, j := 0, 0; i < n && j < m; i++ {
		for j < m && g[i] > s[j] {
			j++
		}
		if j > m {
			ans++
			j++
		}
	}
	return
}

// @lc code=end

