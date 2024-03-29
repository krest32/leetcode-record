import java.util.ArrayList;
import java.util.List;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=783 lang=java
 *
 * [783] 二叉搜索树节点最小距离
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

    public int minDiffInBST(TreeNode root) {
        // DFS
        // return extracted(root);

        // test
        return test(root);
    }

    private int test(TreeNode root) {
        dfsTest(root);
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                ans = Math.min(ans, Math.abs(arr.get(i) - arr.get(j)));
            }
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
        // 删除相邻节点，然后比较
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

}
// @lc code=end
