import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=863 lang=java
 *
 * [863] 二叉树中所有距离为 K 的结点
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Map<Integer, TreeNode> parents = new HashMap<>();
    List<Integer> ans = new ArrayList<Integer>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // 树的反向查找
        // return extracted(root, target, k);

        // test
        return test(root, target, k);
    }

    private List<Integer> test(TreeNode root, TreeNode target, int k) {
        findParentTest(root);
        findAnsTest(target, null, 0, k);
        return ans;
    }

    private void findParentTest(TreeNode root) {
        if (root.left != null) {
            parents.put(root.left.val, root);
            findParentTest(root.left);
        }
        if (root.right != null) {
            parents.put(root.right.val, root);
            findParentTest(root.right);
        }
    }

    private void findAnsTest(TreeNode node, TreeNode from, int i, int k) {
        if (node == null) {
            return;
        }
        if (i == k) {
            ans.add(node.val);
            return;
        }
        if (node.left != from) {
            findAnsTest(node.left, node, i + 1, k);
        }
        if (node.right != from) {
            findAnsTest(node.right, node, i + 1, k);
        }
        if (parents.get(node.val) != from) {
            findAnsTest(parents.get(node.val), node, i + 1, k);
        }
    }

    /**
     * Your runtime beats 99.6 % of java submissions
     * Your memory usage beats 31.51 % of java submissions (41.4 MB)
     * 
     * @param root
     * @param target
     * @param k
     * @return
     */
    private List<Integer> extracted(TreeNode root, TreeNode target, int k) {
        // 从 root 出发 DFS，记录每个结点的父结点
        findParents(root);
        // 从 target 出发 DFS，寻找所有深度为 k 的结点
        findAns(target, null, 0, k);
        return ans;
    }

    /**
     * 记录每个节点的父节点信息
     * 
     * @param node
     */
    public void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            ans.add(node.val);
            return;
        }
        // 向下查找
        if (node.left != from) {
            findAns(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            findAns(node.right, node, depth + 1, k);
        }
        // 向上查找
        if (parents.get(node.val) != from) {
            findAns(parents.get(node.val), node, depth + 1, k);
        }
    }
}
// @lc code=end
