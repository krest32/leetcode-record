import java.util.LinkedList;
import java.util.Queue;
import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
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
    public int findBottomLeftValue(TreeNode root) {
        // 层层倒序遍历
        // 使用BFS算法
        // return extracted(root);

        //
        return test(root);
    }

    private int test(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp = new TreeNode(-100);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            if (temp.left != null) {
                queue.offer(temp.left);
            }
        }
        return temp.val;
    }

    /**
     * 77/77 cases passed (1 ms)
     * Your runtime beats 61.76 % of java submissions
     * Your memory usage beats 5.02 % of java submissions (43.2 MB)
     */
    private int extracted(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp = new TreeNode(-100);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.right != null) {
                queue.offer(temp.right);
            }
            if (temp.left != null) {
                queue.offer(temp.left);
            }
        }
        return temp.val;
    }
}
// @lc code=end
