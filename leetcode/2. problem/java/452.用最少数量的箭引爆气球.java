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
        
        Arrays.sort(points, Comparator.comparing(o -> o[1]));

        int count = 1;
        int end = points[0][1];
        for (int i = 0; i < len; i++) {
            int[] temp = points[i];
            System.out.println(temp);
            int start = temp[0];
            if (start > end) {
                end = temp[1];
                count++;
            }
        }
        return count;
    }

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
