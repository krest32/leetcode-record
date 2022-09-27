import java.time.format.TextStyle;
import java.util.LinkedList;
import java.util.Queue;
import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    // 递归解题
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 递归
        // return extracted(root, targetSum);

        // 迭代-> 广度优先算法
        // return extracted1(root, targetSum);

        // test
        return test(root, targetSum);
    }

    private boolean test(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }

        return test(root.left, targetSum - root.val)
                || test(root.right, targetSum - root.val);
    }

    /**
     * 迭代算法
     * 每一次的累加和与每一层的节点一一对应
     * 
     * @param root
     * @param targetSum
     * @return
     */
    private boolean extracted1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }

    /**
     * 117/117 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 63.99 % of java submissions (41.2 MB)
     * 
     * @param root
     * @param targetSum
     * @return
     */
    private boolean extracted(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        // 判断如果是叶子节点
        if (root.right == null && root.left == null) {
            return targetSum == root.val;
        }
        // 递归判断
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}
// @lc code=end
