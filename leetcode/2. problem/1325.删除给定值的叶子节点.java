import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=1325 lang=java
 *
 * [1325] 删除给定值的叶子节点
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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // 深度有限
        // return extracted(root, target);

        return test(root, target);
    }

    private TreeNode test(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = test(root.left, target);
        root.right = test(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        } else {
            return root;
        }
    }

    /**
     * 50/50 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 99.01 % of java submissions (40.6 MB)
     * 
     * @param root
     * @param target
     * @return
     */
    private TreeNode extracted(TreeNode root, int target) {
        // 后序遍历
        if (root == null)
            return null;
        root.left = extracted(root.left, target);
        root.right = extracted(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }
}
// @lc code=end
