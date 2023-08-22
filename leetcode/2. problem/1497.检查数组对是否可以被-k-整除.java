/*
 * @lc app=leetcode.cn id=1497 lang=java
 *
 * [1497] 检查数组对是否可以被 k 整除
 */

// @lc code=start
class Solution {
    public boolean canArrange(int[] arr, int k) {
        // 统计对 K 求余之后的个数
        // return extracted(arr, k);

        return test(arr, k);
    }

    private boolean test(int[] arr, int k) {
        int[] mod = new int[k];
        for (int num : arr) {
            mod[(num % k + k) % k]++;
        }
        for (int i = 1; i < k; i++) {
            if (mod[i] != mod[k - i]) {
                return false;
            }
        }
        return mod[0] % 2 == 0;
    }

    /**
     * 97/97 cases passed (3 ms)
     * Your runtime beats 99.68 % of java submissions
     * Your memory usage beats 69.9 % of java submissions (49.1 MB)
     * 
     * @param arr
     * @param k
     * @return
     */
    private boolean extracted(int[] arr, int k) {
        // 数组hash，保存对k整除的余数个数
        int[] mod = new int[k];
        // 记录每个余数的个数
        for (int num : arr) {
            mod[(num % k + k) % k]++;
        }

        // 判断 余数个数能否配对成功，如果不成功，直接返回false
        for (int i = 1; i < k; ++i) {
            if (mod[i] != mod[k - i]) {
                return false;
            }
        }

        // 判断 0 的个数需要是2的两倍
        return mod[0] % 2 == 0;
    }
}
// @lc code=end
