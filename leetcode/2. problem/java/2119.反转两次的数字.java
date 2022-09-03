import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=2119 lang=java
 *
 * [2119] 反转两次的数字
 */

// @lc code=start
class Solution {
    public boolean isSameAfterReversals(int num) {
        /**
         * 129/129 cases passed (0 ms)
         * Your runtime beats 100 % of java submissions
         * Your memory usage beats 94.04 % of java submissions (38.1 MB)
         */
        return num == 0 || num % 10 > 0;
    }
}
// @lc code=end
