/*
 * @lc app=leetcode.cn id=1014 lang=java
 *
 * [1014] 最佳观光组合
 */

// @lc code=start
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        // 贪心
        // return method(values);

        return test(values);

    }

    private int test(int[] values) {
        int ans = 0;
        int curMax = values[0] + 0;
        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans, curMax + values[i] - i);
            curMax = Math.max(curMax, values[i] + i);
        }
        return ans;
    }

    private int method(int[] values) {
        // 其中 mx 代表达到该景点最大的
        int ans = 0, mx = values[0] + 0;
        for (int j = 1; j < values.length; ++j) {
            ans = Math.max(ans, mx + values[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, values[j] + j);
        }
        return ans;
    }

}
// @lc code=end
