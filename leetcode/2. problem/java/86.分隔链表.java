import java.util.List;

import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        // 迭代
        // return extracted(head, x);

        // 1
        return test(head, x);

    }

    private ListNode test(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode small = smallHead;
        ListNode largeHead = new ListNode(-1);
        ListNode large = largeHead;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    /**
     * 168/168 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 83.57 % of java submissions (40.7 MB)
     * 
     * @param head
     * @param x
     * @return
     */
    private ListNode extracted(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
// @lc code=end
