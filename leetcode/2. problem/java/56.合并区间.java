import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        // 区间排序
        // return extracted(intervals);

        // 1
        return test(intervals);

    }

    private int[][] test(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < left) {
                ans.add(new int[] { left, right });
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(right, ans.get(ans.size() - 1)[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    /**
     * 170/170 cases passed (7 ms)
     * Your runtime beats 70.52 % of java submissions
     * Your memory usage beats 10.6 % of java submissions (46.7 MB)
     * 
     * @param intervals
     * @return
     */
    private int[][] extracted(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][0];
        // 二维数组排序
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (list.size() == 0
                    || list.get(list.size() - 1)[1] < left) {
                list.add(new int[] { left, right });
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], right);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
// @lc code=end
