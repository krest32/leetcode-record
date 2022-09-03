import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=2236 lang=java
 *
 * [2236] 判断根结点是否等于子结点之和
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
    public boolean checkTree(TreeNode root) {
        // 模拟
        return extracted(root);
    }

    /**
     * 309/309 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 39.28 % of java submissions (39.3 MB)
     * 
     * @param root
     * @return
     */
    private boolean extracted(TreeNode root) {
        if (root != null
                && root.left != null
                && root.right != null
                && root.val == root.left.val + root.right.val) {
            return true;
        }
        return false;
    }
}
// @lc code=end
