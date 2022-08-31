import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=1448 lang=java
 *
 * [1448] 统计二叉树中好节点的数目
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    int ans = 0;

    public int goodNodes(TreeNode root) {
        // return extracted(root);

        // 1 test
        return test(root);
    }

    private int test(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfsTest(root, root.val);
        return ans;
    }

    private void dfsTest(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val >= val) {
            ans++;
            val = root.val;
        }
        dfsTest(root.left, val);
        dfsTest(root.right, val);

    }

    /**
     * 63/63 cases passed (2 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 40.62 % of java submissions (49.6 MB)
     * 
     * @param root
     * @return
     */
    private int extracted(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, root.val);
        return ans;
    }

    void dfs(TreeNode node, int curMax) {
        if (node == null)
            return;
        // 给一个最大的值
        if (node.val >= curMax) {
            ans++;
            curMax = node.val;
        }
        dfs(node.left, curMax);
        dfs(node.right, curMax);
    }
}
// @lc code=end
