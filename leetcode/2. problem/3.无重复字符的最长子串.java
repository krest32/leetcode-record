import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口 + 哈希
        // return extracted(s);

        // 滑动窗口 --> 最优解
        // return extracted2(s);

        return test(s);

    }

    private int test(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(ch) + 1);
            }
            ans = Math.max(ans, right - left + 1);
            map.put(ch, right);
        }
        return ans;
    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 18.78 % of java submissions (41.6 MB)
     * 
     * @param s
     * @return
     */
    private int extracted2(String s) {
        // 左指针
        int left = 0;
        // 有指针
        int right = 0;
        int curLen = 0;
        int result = 0;
        while (left < s.length()) {
            // 判断有没有重复字符，同时确认当前上一个重复字符的长度，求取这段区间的长度
            int pos = s.indexOf(s.charAt(left), right);
            if (pos < left) {
                result = Math.max(result, curLen);
                if (result >= s.length() - pos - 1)
                    return result;
                curLen = left - pos - 1;
                right = pos + 1;
            }
            // 如果没有重复字符，记录长度
            curLen++;
            left++;
        }
        return curLen;
    }

    /**
     * 987/987 cases passed (4 ms)
     * Your runtime beats 87.47 % of java submissions
     * Your memory usage beats 41.72 % of java submissions (41.7 MB)
     * 
     * @param s
     * @return
     */
    private int extracted(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // len =字符串长度，ans为返回答案
        int len = s.length(), ans = 0;
        for (int right = 0, left = 0; right < len; right++) {
            if (map.containsKey(s.charAt(right)))
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            // 取最大值防止区间左端点回退情况
            // 区间右端点下标-区间左端点下标 +1 = 区间长度
            ans = Math.max(ans, right - left + 1);
            // 注意，更新字符对应的下标。
            map.put(s.charAt(right), right);
        }
        return ans;
    }
}
// @lc code=end
