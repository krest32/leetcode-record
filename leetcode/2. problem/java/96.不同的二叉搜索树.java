import java.util.ArrayList;
import java.util.List;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        // 动态规划
        // return extracted(n);

        // 回溯：超时
        // return extracted2(1, n).size();

        // test
        return test(n);

    }

    private int test(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * 19/19 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 28.65 % of java submissions (38.4 MB)
     * 
     * @param n
     * @return
     */
    private int extracted(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // j 代表根节点的数字，0 不能是根节点, i可以作为根节点
            for (int j = 1; j <= i; j++) {
                // j-1 是为了去掉根节点的占用数量
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    /**
     * Time Limit Exceeded
     * 12/19 cases passed (N/A)
     * 
     * @param start
     * @param end
     * @return
     */
    private List<TreeNode> extracted2(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = extracted2(start, i - 1);
                List<TreeNode> right = extracted2(i + 1, end);
                for (TreeNode tempLeft : left) {
                    for (TreeNode tempRight : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = tempLeft;
                        root.right = tempRight;
                        ans.add(root);
                    }
                }
            }
        }
        return ans;
    }

}
// @lc code=end
