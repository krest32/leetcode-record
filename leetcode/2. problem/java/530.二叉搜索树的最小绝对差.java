import java.util.ArrayList;
import java.util.List;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    int pre;
    int ans = Integer.MAX_VALUE;
    List<Integer> arr = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        // dfs 算法
        // return extracted(root);

        // 中序遍历
        return test(root);
    }

    private int test(TreeNode root) {
        dfsTest(root);
        for (int i = 1; i < arr.size(); i++) {
            ans = Math.min(ans, arr.get(i) - arr.get(i - 1));
        }
        return ans;
    }

    private void dfsTest(TreeNode root) {
        if (root == null) {
            return;
        }
        dfsTest(root.left);
        arr.add(root.val);
        dfsTest(root.right);
    }

    private int extracted(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    /***
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 28.76 % of java submissions (41.1 MB)
     * 
     * @param root
     */
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            // 每次更新pre
            pre = root.val;
        }
        dfs(root.right);
    }
}

// @lc code=end
