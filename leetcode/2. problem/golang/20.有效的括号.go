/*
 * @lc app=leetcode.cn id=20 lang=golang
 *
 * [20] 有效的括号
 */

// @lc code=start
func isValid(s string) bool {
	// return method1(s)

	return test(s)
}

func test(s string) bool {
	length := len(s)
	if length%2 == 1 {
		return false
	}

	data := map[byte]byte{')': '(', ']': '[', '}': '{'}
	stack := []byte{}
	for i := 0; i < length; i++ {
		if data[s[i]] > 0 {
			if len(stack) == 0 || stack[len(stack)-1] != data[s[i]] {
				return false
			}
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, s[i])
		}
	}
	return len(stack) == 0
}

func method1(s string) bool {
	length := len(s)
	if length%2 == 1 {
		return false
	}
	// 确认配对方式
	pairs := map[byte]byte{')': '(', '}': '{', ']': '['}
	// 此处定义个一个切片数组
	stack := []byte{}
	for i := 0; i < length; i++ {
		// 如果当前元素在配对中存在
		if pairs[s[i]] > 0 {
			// 如果找不到相互匹配的元素，就退出
			if len(stack) == 0 || stack[len(stack)-1] != pairs[s[i]] {
				return false
			}
			// 移除stack中的元素
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, s[i])
		}
	}
	return len(stack) == 0
}

// @lc code=end

