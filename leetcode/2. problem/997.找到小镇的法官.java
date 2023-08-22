
/*
 * @lc app=leetcode.cn id=997 lang=java
 *
 * [997] 找到小镇的法官
 */

// @lc code=start
class Solution {
    public int findJudge(int n, int[][] trust) {
        // 模拟计数
        // return extracted(n, trust);

        // 测试
        return test(n, trust);

    }

    private int test(int n, int[][] trust) {
        // 被信任个数
        int[] trustInArr = new int[n + 1];
        // 信任的个数
        int[] trustOutArr = new int[n + 1];
        for (int[] tempArr : trust) {
            int x = tempArr[0], y = tempArr[1];
            trustInArr[y]++;
            trustOutArr[x]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trustInArr[i] == n - 1 && trustOutArr[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 92/92 cases passed (2 ms)
     * Your runtime beats 97.93 % of java submissions
     * Your memory usage beats 50.29 % of java submissions (48.9 MB)
     * 
     * @param n
     * @param trust
     * @return
     */
    private int extracted(int n, int[][] trust) {
        int[] inDegrees = new int[n + 1];
        int[] outDegrees = new int[n + 1];
        for (int[] edge : trust) {
            int x = edge[0], y = edge[1];
            inDegrees[y]++;
            outDegrees[x]++;
        }
        for (int i = 1; i <= n; ++i) {
            if (inDegrees[i] == n - 1 && outDegrees[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end
