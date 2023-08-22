import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
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
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        // 以当前节点为终点，分别向左右两边发散
        // return extracted(root);

        // test
        return test(root);
    }

    private int test(TreeNode root) {
        ans = 0;
        dfsTest(root);
        return ans;
    }

    private int dfsTest(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfsTest(root.left);
        int right = dfsTest(root.right);
        int tempLeft = 0, tempRight = 0;
        if (root.left != null && root.val == root.left.val) {
            tempLeft = left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            tempRight = right + 1;
        }
        ans = Math.max(ans, tempLeft + tempRight);
        return Math.max(tempLeft, tempRight);
    }

    /**
     * 71/71 cases passed (2 ms)
     * Your runtime beats 97.8 % of java submissions
     * Your memory usage beats 79.67 % of java submissions (44.8 MB)
     * 
     * @param root
     * @return
     */
    private int extracted(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode node) {
        if (node == null)
            return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
// @lc code=end
