import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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

    // 递归：定义出全局变量
    int depth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        // 递归
        // return extracted(root);

        // test
        return test(root);
    }

    private int test(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null) {
            depth = Math.min(depth, test(root.left));
        }
        if (root.right != null) {
            depth = Math.min(depth, test(root.right));
        }
        return depth + 1;

    }

    /**
     * 52/52 cases passed (11 ms)
     * Your runtime beats 11.82 % of java submissions
     * Your memory usage beats 36.78 % of java submissions (61.3 MB)
     * 
     * @param root
     * @return
     */
    private int extracted(TreeNode root) {
        // 进行判空处理
        if (root == null) {
            return 0;
            // 判断左右子树都为 null 的情况
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            // 分别比较左右子树，获取树的最小深度
            if (root.left != null) {
                depth = Math.min(depth, minDepth(root.left));
            }
            if (root.right != null) {
                depth = Math.min(depth, minDepth(root.right));
            }
            return depth + 1;
        }
    }
}
// @lc code=end
