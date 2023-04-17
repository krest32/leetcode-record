import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=467 lang=java
 *
 * [467] 环绕字符串中唯一的子字符串
 */

// @lc code=start
class Solution {
    public int findSubstringInWraproundString(String p) {
        // 动态规划
        // return extracted(p);

        return test(p);
    }

    private int test(String p) {
        // 记录到达该字符串，且以该字符结尾的字符串个数
        int[] dp = new int[26];
        int lastChar = -1, max = 0;
        for (char ch : p.toCharArray()) {
            int curChar = ch - 'a';
            if (lastChar + 1 == curChar || (lastChar == 25 && curChar == 0)) {
                max += 1;
            } else {
                max = 1;
            }
            if (max > dp[curChar]) {
                dp[curChar] = max;
            }
            lastChar = curChar;
        }
        return Arrays.stream(dp).sum();
    }

    /**
     * 81/81 cases passed (4 ms)
     * Your runtime beats 88.76 % of java submissions
     * Your memory usage beats 15.3 % of java submissions (41.5 MB)
     * 
     * @param p
     * @return
     */
    private int extracted(String p) {
        // 记录到达该字符串，且以该字符结尾的字符串个数
        int[] dp = new int[26];
        int last = -1, max = 0;
        for (char ch : p.toCharArray()) {
            int cur = ch - 'a';
            if (last + 1 == cur || (last == 25 && cur == 0)) {
                max = max + 1;
            } else {
                max = 1;
            }
            if (max > dp[cur]) {
                dp[cur] = max;
            }
            last = cur;
        }
        return Arrays.stream(dp).sum();
    }
}
// @lc code=end
