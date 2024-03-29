import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1024 lang=java
 *
 * [1024] 视频拼接
 */

// @lc code=start
class Solution {
    public int videoStitching(int[][] clips, int time) {
        // 动态规划
        // return extracted(clips, time);

        // 1
        return test(clips, time);

    }

    private int test(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 0; i <= time; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time] = dp[time] == Integer.MAX_VALUE - 1 ? -1 : dp[time];
    }

    /**
     * 60/60 cases passed (1 ms)
     * Your runtime beats 84.78 % of java submissions
     * Your memory usage beats 28.33 % of java submissions (39.4 MB)
     * 
     * @param clips
     * @param time
     * @return
     */
    private int extracted(int[][] clips, int time) {
        // 记录 i 时间的最小时评片段匹配数
        int[] dp = new int[time + 1];
        // 初始化 0 值
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= time; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time] == Integer.MAX_VALUE - 1 ? -1 : dp[time];
    }
}
// @lc code=end
