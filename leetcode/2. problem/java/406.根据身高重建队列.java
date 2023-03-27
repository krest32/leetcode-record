import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 区间排序
        // return extracted(people);

        // test
        return test(people);
    }

    private int[][] test(int[][] people) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(people, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    /*
     * 36/36 cases passed (6 ms)
     * Your runtime beats 80.41 % of java submissions
     * Your memory usage beats 52.92 % of java submissions (42.3 MB)
     */
    private int[][] extracted(int[][] people) {
        // 排序 如果身高相同，那么就按照另一个条件降序排序
        Arrays.sort(people, (o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            // person[1] 表示person要插入队列当中的位置
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
// @lc code=end
