import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=2365 lang=java
 *
 * [2365] 任务调度器 II
 */

// @lc code=start
class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        // 贪心，逆向思维
        long ans = 0;
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            ans++;
            int type = tasks[i];
            if (map.containsKey(type)) {
                ans = Math.max(ans, map.get(type) + space + 1);
            }
            map.put(type, ans);
        }
        return ans;
    }
}
// @lc code=end
