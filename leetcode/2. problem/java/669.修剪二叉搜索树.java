import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=669 lang=java
 *
 * [669] 修剪二叉搜索树
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 递归
        // return extracted(root, low, high);

        // test
        return test(root, low, high);
    }

    private TreeNode test(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }
        if (root.val > high) {
            return test(root.left, low, high);
        }

        if (root.val < low) {
            return test(root.right, low, high);
        }
        root.left = test(root.left, low, high);
        root.right = test(root.right, low, high);
        return root;
    }

    /**
     * 78/78 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 23.77 % of java submissions (41.3 MB)
     * 
     * @param root
     * @param low
     * @param high
     * @return
     */
    private TreeNode extracted(TreeNode root, int low, int high) {
        if (root == null)
            return root;
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
// @lc code=end
