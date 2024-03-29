import entrty.ListNode;
import entrty.TreeNode;

/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // 通过中序遍历构建二叉树
        // return buildTree(head, null);

        // test
        return test(head, null);
    }

    private TreeNode test(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode middle = getMiddle(left, right);
        TreeNode root = new TreeNode(middle.val);
        root.left = test(left, middle);
        root.right = test(middle.next, right);
        return root;
    }

    private ListNode getMiddle(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 32/32 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 54.05 % of java submissions (42.6 MB)
     * 
     * @param left
     * @param right
     * @return
     */
    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        // 获取链表的中间节点作为根节点
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        // 构建左子树
        root.left = buildTree(left, mid);
        // 构建右子树
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
// @lc code=end
