import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        // 矩阵排序
        // return extracted(points);

        // test
        return test(points);
    }

    private int test(int[][] points) {
        int len = points.length;
        if (len == 0) {
            return 0;
        }
        int count = 1;
        Arrays.sort(points, Comparator.comparing(o -> o[1]));
        int end = points[0][1];
        for (int i = 1; i < len; i++) {
            int[] temp = points[i];
            int start = temp[0];
            if (end < start) {
                count++;
                end = temp[1];
            }
        }
        return count;
    }

    /**
     * 50/50 cases passed (95 ms)
     * Your runtime beats 5.05 % of java submissions
     * Your memory usage beats 8.57 % of java submissions (78.4 MB)
     * 
     * @param points
     * @return
     */
    private int extracted(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparing(o -> o[1]));
        int count = 1;
        int end = points[0][1];
        for (int[] ballon : points) {
            if (ballon[0] > end) {
                end = ballon[1];
                count++;
            }
        }
        return count;
    }
}
// @lc code=end
