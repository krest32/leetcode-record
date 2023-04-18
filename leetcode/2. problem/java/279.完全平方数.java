import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.text.html.ListView;

/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        // 广度遍历
        // return extracted(n);

        // 动态规划 完全背包 反向遍历
        // return extracted2(n);

        // 动态规划 完全背包 正向遍历
        return extracted3(n);

    }

    /**
     * 588/588 cases passed (45 ms)
     * Your runtime beats 32.64 % of java submissions
     * Your memory usage beats 24.19 % of java submissions (40.9 MB)
     * 
     * @param n
     * @return
     */
    private int extracted3(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 588/588 cases passed (25 ms)
     * Your runtime beats 69.52 % of java submissions
     * Your memory usage beats 65.64 % of java submissions (40.5 MB)
     * 
     * @param n
     * @return
     */
    private int extracted2(int n) {
        // dp[i] 记录组成 i 的最小平方数
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, max);
        // 初始值化 dp
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            // 需要使用到的是 i*i ，所以從 i*i 开始计数
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }

    private int extracted(int n) {
        List<Integer> squares = generaterSquare(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        queue.offer(n);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = size; i > 0; i--) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (next == 0) {
                        return level;
                    } else if (next < 0) {
                        break;
                    }
                    if (visited[next]) {
                        continue;
                    } else {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return n;
    }

    // 得到所有数的平方数
    private List<Integer> generaterSquare(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            // 找到所有的平方数
            squares.add(square);
            square = square + diff;
            diff = diff + 2;
        }
        return squares;
    }
}
// @lc code=end
