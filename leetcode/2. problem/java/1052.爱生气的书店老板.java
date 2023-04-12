/*
 * @lc app=leetcode.cn id=1052 lang=java
 *
 * [1052] 爱生气的书店老板
 */

// @lc code=start
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        // return extracted(customers, grumpy, minutes);

        return test(customers, grumpy, minutes);

    }

    private int test(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        int len = customers.length;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        // 初始的窗口值
        int increase = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] != 0) {
                increase += customers[i];
            }
        }
        int maxIncrease = increase;
        for (int i = minutes; i < len; i++) {
            increase = increase
                    - customers[i - minutes] * grumpy[i - minutes]
                    + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }

        return total + maxIncrease;
    }

    /**
     * 78/78 cases passed (2 ms)
     * Your runtime beats 99.57 % of java submissions
     * Your memory usage beats 79.26 % of java submissions (44.2 MB)
     * 
     * @param customers
     * @param grumpy
     * @param minutes
     * @return
     */
    private int extracted(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        int n = customers.length;
        // 先获取默认情况下，顾客满意的人数
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int increase = 0;
        // 初始情况下：如果一直不生气，增加的顾客数
        for (int i = 0; i < minutes; i++) {
            increase += customers[i] * grumpy[i];
        }
        int maxIncrease = increase;

        // 如果持续不生气，这段时间内，顾客都会满意
        for (int i = minutes; i < n; i++) {
            // 最大增加量减去不在这段时间内的客户数量
            increase = increase - customers[i - minutes] * grumpy[i - minutes]
                    + customers[i] * grumpy[i];
            maxIncrease = Math.max(maxIncrease, increase);
        }
        return total + maxIncrease;
    }
}
// @lc code=end
