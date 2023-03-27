import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 排序
        // return extracted(intervals);

        // test
        return test(intervals);
    }

    private int test(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int len = intervals.length;
        int count = 1;
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int end = intervals[0][1];
        for (int i = 1; i < len; i++) {
            int[] temp = intervals[i];
            int start = temp[0];
            if (end <= start) {
                count += 1;
                end = temp[1];
            }
        }
        return len - count;

    }

    /**
     * d
     * 58/58 cases passed (48 ms)
     * Your runtime beats 77.25 % of java submissions
     * Your memory usage beats 68.64 % of java submissions (97.7 MB)
     * 
     * @param intervals
     * @return
     */
    private int extracted(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = intervals[i];
            int start = temp[0];
            if (end <= start) {
                count += 1;
                end = temp[1];
            }
        }
        return intervals.length - count;
    }
}
// @lc code=end
