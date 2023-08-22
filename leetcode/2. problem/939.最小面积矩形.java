import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=939 lang=java
 *
 * [939] 最小面积矩形
 */

// @lc code=start
class Solution {
    public int minAreaRect(int[][] points) {
        return extracted(points);
    }

    /**
     * 137/137 cases passed (160 ms)
     * Your runtime beats 52.87 % of java submissions
     * Your memory usage beats 24.84 % of java submissions (59.3 MB)
     * 
     * @param points
     * @return
     */
    private int extracted(int[][] points) {
        Map<Integer, List<Integer>> rows = new TreeMap<>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            rows.computeIfAbsent(x, z -> new ArrayList<>()).add(y);
        }

        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> lastx = new HashMap<>();
        for (int x : rows.keySet()) {
            List<Integer> row = rows.get(x);
            Collections.sort(row);
            for (int i = 0; i < row.size(); ++i) {
                for (int j = i + 1; j < row.size(); ++j) {
                    int y1 = row.get(i), y2 = row.get(j);
                    int code = 40001 * y1 + y2;
                    if (lastx.containsKey(code))
                        ans = Math.min(ans, (x - lastx.get(code)) * (y2 - y1));
                    lastx.put(code, x);
                }
            }
        }
        return ans < Integer.MAX_VALUE ? ans : 0;
    }
}
// @lc code=end
