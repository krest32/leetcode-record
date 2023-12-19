import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=1721 lang=java
 *
 * [1721] 交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        // 迭代
        // return extracted(head, k);

        return test(head, k);
    }

    private ListNode test(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        // 找到左节点
        while (k > 1) {
            left = left.next;
            k--;
        }

        ListNode cur = left;
        while (cur.next != null) {
            cur = cur.next;
            right = right.next;
        }
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }

    /**
     * 132/132 cases passed (2 ms)
     * Your runtime beats 99.35 % of java submissions
     * Your memory usage beats 57.74 % of java submissions (55.8 MB)
     * 
     * @param head
     * @param k
     * @return
     */
    private ListNode extracted(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        // 找到左节点
        while (k > 1) {
            left = left.next;
            k--;
        }

        ListNode cur = left;
        while (cur.next != null) {
            cur = cur.next;
            right = right.next;
        }
        int temp = left.val;
        left.val = right.val;
        right.val = temp;
        return head;
    }
}
// @lc code=end
