import java.util.LinkedList;
import java.util.Queue;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=965 lang=java
 *
 * [965] 单值二叉树
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
    int val;

    public boolean isUnivalTree(TreeNode root) {
        // return extracted(root);

        return method2(root);
    }

    /**
     * 72/72 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 8.12 % of java submissions (39.4 MB)
     * 
     * @param root
     * @return
     */
    private boolean method2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int val = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (val != node.val) {
                    return false;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return true;
    }

    private boolean extracted(TreeNode root) {
        if (root == null) {
            return true;
        }
        val = root.val;
        return dfs(root.left) && dfs(root.right);
    }

    private boolean dfs(TreeNode node) {
        if (node == null)
            return true;

        return node.val == val
                && dfs(node.left)
                && dfs(node.right);

    }
}
// @lc code=end
