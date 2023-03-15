/*
 * @lc app=leetcode.cn id=598 lang=java
 *
 * [598] 范围求和 II
 */

// @lc code=start
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        // 模拟
        // return extracted(m, n, ops);

        // 测试
        return test(m, n, ops);
    }

    private int test(int m, int n, int[][] ops) {
        int minA = m, minB = n;
        for (int[] arr : ops) {
            minA = Math.min(minA, arr[0]);
            minB = Math.min(minB, arr[1]);
        }
        return minA * minB;
    }

    /**
     * 69/69 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 42.04 % of java submissions (41.5 MB)
     * 
     * @param m
     * @param n
     * @param ops
     * @return
     */
    private int extracted(int m, int n, int[][] ops) {
        // 求取得到最小的边界值
        int mina = m, minb = n;
        for (int[] op : ops) {
            mina = Math.min(mina, op[0]);
            minb = Math.min(minb, op[1]);
        }
        return mina * minb;
    }
}
// @lc code=end
