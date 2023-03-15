import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1893 lang=java
 *
 * [1893] 检查是否区域内所有整数都被覆盖
 */

// @lc code=start
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        // 暴力
        // return extracted(ranges, left, right);

        return test(ranges, left, right);
    }

    /**
     * 105/105 cases passed (1 ms)
     * Your runtime beats 51.98 % of java submissions
     * Your memory usage beats 58.19 % of java submissions (39.6 MB)
     * 
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    private boolean test(int[][] ranges, int left, int right) {
        Boolean[] flagArr = new Boolean[right + 1];
        Arrays.fill(flagArr, false);
        for (int i = left; i <= right; i++) {
            for (int[] arr : ranges) {
                if (arr[0] <= i && arr[1] >= i) {
                    flagArr[i] = true;
                }
            }
        }
        for (int i = left; i <= right; i++) {
            if (flagArr[i] == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 105/105 cases passed (1 ms)
     * Your runtime beats 51.98 % of java submissions
     * Your memory usage beats 58.19 % of java submissions (39.6 MB)
     * 
     * 
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    private boolean extracted(int[][] ranges, int left, int right) {
        Boolean[] flagArr = new Boolean[right + 1];
        Arrays.fill(flagArr, false);
        for (int i = left; i <= right; i++) {
            for (int[] arr : ranges) {
                if (arr[0] <= i && arr[1] >= i) {
                    flagArr[i] = true;
                }
            }
        }
        for (int i = left; i <= right; i++) {
            if (flagArr[i] == false) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
