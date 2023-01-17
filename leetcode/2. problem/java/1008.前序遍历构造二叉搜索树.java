import org.omg.CosNaming.NamingContextPackage.NotEmpty;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=1008 lang=java
 *
 * [1008] 前序遍历构造二叉搜索树
 */

// @lc code=start

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }
        return dfs(preorder, 0, len - 1);
    }

    private TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        TreeNode node = new TreeNode(preorder[left]);
        if (left == right)
            return node;
        int l = left, r = right;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (preorder[mid] < preorder[left]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        node.left = dfs(preorder, left + 1, l);
        node.right = dfs(preorder, l + 1, right);
        return node;
    }
}
// @lc code=end
