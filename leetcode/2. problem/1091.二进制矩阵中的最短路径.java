import java.util.LinkedList;
import java.util.Queue;


/*
 * @lc app=leetcode.cn id=1091 lang=java
 *
 * [1091] 二进制矩阵中的最短路径
 */

// @lc code=start
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // BFS
        // return extracted(grid);

        // test
        return testMatrix(grid);
    }

    private int testMatrix(int[][] grid) {
        int len = grid.length;
        if (grid[0][0] == 1 || grid[len - 1][len - 1] == 1) {
            return -1;
        }
        int[][] direcs = { { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, 1 },
                { 0, -1 }, { -1, 1 }, { -1, 0 }, { -1, -1 } };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        grid[0][0] = 1;
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                int newi = temp[0];
                int newj = temp[1];
                if (newi == len - 1 && newj == len - 1) {
                    return ans;
                }
                for (int j = 0; j < 8; j++) {
                    int xx = newi + direcs[j][0];
                    int yy = newj + direcs[j][1];
                    if (xx >= 0 && xx < len && yy >= 0 && yy < len && grid[xx][yy] == 0) {
                        queue.offer(new int[] { xx, yy });
                        grid[xx][yy] = 1;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 88/88 cases passed (9 ms)
     * Your runtime beats 99.37 % of java submissions
     * Your memory usage beats 82.65 % of java submissions (42.3 MB)
     * 
     * @param grid
     * @return
     */
    private int extracted(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) { // 只有两端都是0才可以开始
            return -1;
        }
        int count = 0;
        int[] dx = { 0, 1, 0, -1, 1, -1, 1, -1 };
        int[] dy = { 1, 0, -1, 0, 1, -1, -1, 1 }; // 8个位置
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { 0, 0 });
        // 走过的标记为1，这样就可以走最短的了
        grid[0][0] = 1;
        // 进入BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) { // 逐层搜索
                int[] tmp = queue.poll();
                int x = tmp[0];
                int y = tmp[1];
                if (x == n - 1 && y == n - 1) { // 到达终点就返回
                    return count;
                }
                for (int k = 0; k < 8; k++) {
                    int xx = x + dx[k];
                    int yy = y + dy[k];
                    // 加入下一层的数
                    if (xx >= 0 && xx < n && yy >= 0 && yy < n && grid[xx][yy] == 0) {
                        queue.offer(new int[] { xx, yy });
                        grid[xx][yy] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
// @lc code=end
