import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=1647 lang=java
 *
 * [1647] 字符频次唯一的最小删除次数
 */

// @lc code=start
class Solution {
    public int minDeletions(String s) {
        // 贪心 + Set
        return extracted(s);
    }

    /**
     * 103/103 cases passed (6 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 36.22 % of java submissions (42.2 MB)
     * 
     * @param s
     * @return
     */
    private int extracted(String s) {
        int[] cnt = new int[26];
        // 统计每个字符的个数
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }
        int ret = 0;

        // 记录不包含的字符的数量，如果出现，就减去，记录减去的数量
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < cnt.length; i++) {
            int count = cnt[i];
            while (count > 0) {
                if (set.contains(count)) {
                    count--;
                    ret++;
                } else {
                    set.add(count);
                    break;
                }
            }
        }
        return ret;
    }
}
// @lc code=end
