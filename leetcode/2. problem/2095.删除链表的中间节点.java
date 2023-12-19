import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=2095 lang=java
 *
 * [2095] 删除链表的中间节点
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
    public ListNode deleteMiddle(ListNode head) {
        // 迭代
        // return getFast(head);

        // test
        return test(head);
    }

    private ListNode test(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode slow = new ListNode(-1, head);
        ListNode fast = new ListNode(-1, head);
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    /**
     * 70/70 cases passed (3 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 33.86 % of java submissions (62.2 MB)
     */
    private ListNode getFast(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode fast = new ListNode(), slow = new ListNode();
        fast.next = head;
        slow.next = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.next.val);
        slow.next = slow.next.next;
        return head;
    }
}
// @lc code=end
