import java.util.ArrayList;
import java.util.List;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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
    public List<TreeNode> generateTrees(int n) {
        // 回溯解法
        // return extracted(n);

        // test
        return test(n);

    }

    private List<TreeNode> test(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        return buildTreeTest(1, n);
    }

    private List<TreeNode> buildTreeTest(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> lefts = buildTreeTest(start, i - 1);
                List<TreeNode> rights = buildTreeTest(i + 1, end);
                for (TreeNode tempLeft : lefts) {
                    for (TreeNode tempRigt : rights) {
                        TreeNode root = new TreeNode(i);
                        root.left = tempLeft;
                        root.right = tempRigt;
                        ans.add(root);
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 8/8 cases passed (1 ms)
     * Your runtime beats 97.75 % of java submissions
     * Your memory usage beats 32.29 % of java submissions (42.2 MB)
     * 
     * @param n
     * @return
     */
    private List<TreeNode> extracted(int n) {
        if (n == 0)
            return new ArrayList<TreeNode>();
        return buildTree(1, n);
    }

    private List<TreeNode> buildTree(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        // 不满足二叉树的条件，节点添加null
        if (start > end) {
            ans.add(null);
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = buildTree(start, i - 1);
                List<TreeNode> right = buildTree(i + 1, end);
                for (TreeNode tempLeft : left) {
                    for (TreeNode tempRight : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = tempLeft;
                        root.right = tempRight;
                        ans.add(root);
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end
