import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public boolean isValidBST(TreeNode root) {
        // 深度有限遍历
        // return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);

        // test
        return test(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean test(TreeNode root, long minValue, long maxValue) {
        if (root == null)
            return true;
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return test(root.left, minValue, root.val)
                && test(root.right, root.val, maxValue);
    }

    /**
     * 80/80 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 80.78 % of java submissions (40.8 MB)
     * 
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    private boolean dfs(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val >= upper || node.val <= lower) {
            return false;
        }
        return dfs(node.left, lower, node.val)
                && dfs(node.right, node.val, upper);
    }
}
// @lc code=end
