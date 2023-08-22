import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.parser.Entity;

import java.util.Set;

/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 贪心 + 模拟
        // return extracted(tasks, n);

        // test
        return test(tasks, n);
    }

    private int test(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxExec = 0;
        for (char ch : tasks) {
            int cnt = map.getOrDefault(ch, 0) + 1;
            map.put(ch, cnt);
            maxExec = Math.max(cnt, maxExec);
        }

        int maxExecCnt = 0;
        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            Integer value = entry.getValue();
            if (value == maxExec) {
                maxExecCnt++;
            }
        }
        return Math.max((maxExec - 1) * (n + 1) + maxExecCnt, tasks.length);
    }

    /**
     * 执行用时：15 ms 在所有 Java 提交中击败了 36.35% 的用户
     * 内存消耗：42.2 MB, 在所有 Java 提交中击败了76.85%的用户
     * 通过测试用例：71 / 71
     * 
     * 
     * @param tasks
     * @param n
     * @return
     */
    private int extracted(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        // 最多的执行次数
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }

        // 具有最多执行次数的任务数量
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                maxCount++;
            }
        }
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
}
// @lc code=end
