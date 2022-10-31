import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=781 lang=java
 *
 * [781] 森林中的兔子
 */

// @lc code=start
class Solution {
    public int numRabbits(int[] answers) {
        // 1
        // return extracted(answers);

        // 分情况讨论
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey();
            int x = entry.getValue();
            if (y == 0) {
                ans += x;
            } else if (y + 1 >= x) {
                ans += (y + 1);
            } else {
                ans+=(x + y) / (y + 1) * (y + 1);
            }
        }
        return ans;
    }

    private int extracted(int[] answers) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey();
            int x = entry.getValue();
            ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }
}
// @lc code=end
