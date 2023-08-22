import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] 替换后的最长重复字符
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        // return extracted(s, k);

        // test
        return test(s, k);
    }

    private int test(String s, int k) {
        int len = s.length();
        int left = 0;
        int maxLen = 0, winLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            winLen = Math.max(winLen, map.get(ch));
            if ((winLen + k) < (i - left + 1)) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    /**
     * 37/37 cases passed (27 ms)
     * Your runtime beats 9.95 % of java submissions
     * Your memory usage beats 38.44 % of java submissions (41.4 MB)
     * 
     * @param s
     * @param k
     * @return
     */
    private int extracted(String s, int k) {
        char[] chars = s.toCharArray();
        int left = 0;
        // 当前窗口最大次数的数值
        int winMax = 0;
        // 窗口长度，即最终结果
        int winLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(chars[right], map.getOrDefault(chars[right], 0) + 1);
            // 更新当前窗口出现的最多字母的次数，因为循环每次只增加一个，
            // 所以一直更新winMax即可
            winMax = Math.max(winMax, map.get(chars[right]));
            // 窗口状态
            if ((winMax + k) < (right - left + 1)) {
                map.put(chars[left], map.get(chars[left]) - 1);
                left++;
            }
            // 每次循环结束前，更新窗口长度
            winLength = Math.max(winLength, right - left + 1);
        }
        // 输出最大窗口
        return winLength;
    }
}
// @lc code=end
