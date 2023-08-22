
/*
 * @lc app=leetcode.cn id=1539 lang=java
 *
 * [1539] 第 k 个缺失的正整数
 */

// @lc code=start
class Solution {
    public int findKthPositive(int[] arr, int k) {
        // 暴力
        return extracted(arr, k);
    }

    /**
     * 84/84 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 22.16 % of java submissions (41.1 MB)
     */
    private int extracted(int[] arr, int k) {
        int missCount = 0, lastMiss = -1, current = 1, ptr = 0;
        for (missCount = 0; missCount < k; ++current) {
            if (current == arr[ptr]) {
                ptr = (ptr + 1 < arr.length) ? ptr + 1 : ptr;
            } else {
                missCount++;
                lastMiss = current;
            }
        }
        return lastMiss;
    }
}
// @lc code=end
