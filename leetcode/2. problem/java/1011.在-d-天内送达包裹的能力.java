
/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * 、
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        return extracted(weights, days);
    }

    /**
     * 85/85 cases passed (11 ms)
     * Your runtime beats 62.33 % of java submissions
     * Your memory usage beats 90.95 % of java submissions (44.7 MB)
     * 
     * @param weights
     * @param days
     * @return
     */
    private int extracted(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        // 得到最大单位、累加和
        for (int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }

        int left = max, right = sum;
        // 二分查找，判断最低载重
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 判断能够运输的货物下标
    private boolean check(int[] weights, int mid, int days) {
        int n = weights.length;
        int cnt = 1;
        for (int i = 1, sum = weights[0]; i < n; sum = 0, cnt++) {
            while (i < n && sum + weights[i] <= mid) {
                sum += weights[i];
                i++;
            }
        }
        return cnt - 1 <= days;
    }

}
// @lc code=end
