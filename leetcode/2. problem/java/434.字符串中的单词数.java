/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {
        // 模拟 空个数+1
        // return extracted(s);

        // test
        return test(s);
    }

    /**
     * 28/28 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 81.43 % of java submissions (39.1 MB)
     * 
     * @param s
     * @return
     */
    private int test(String s) {
        String[] strArr = s.split(" ");
        int ans = 0;
        for (String tempStr : strArr) {
            if (tempStr.length() > 0) {
                ans++;
            }
        }
        return ans;
    }

    private int extracted(String s) {
        int segmentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }
        return segmentCount;
    }
}
// @lc code=end
