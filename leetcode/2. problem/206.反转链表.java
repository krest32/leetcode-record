
import java.util.ArrayList;
import java.util.List;

import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        // 最好不要使用额外的空间
        // 迭代
        // return extracted(head);

        // 递归
        // return extracted2(head);

        // 使用 List
        // return extracted3(head);

        // 1迭代
        return test1(head);

    }

    private ListNode test1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 28/28 cases passed (1 ms)
     * Your runtime beats 4.61 % of java submissions
     * Your memory usage beats 40.41 % of java submissions (41.4 MB)
     * 
     * @param head
     * @return
     */
    private ListNode extracted3(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        for (ListNode node : list) {
            node.next = null;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        for (int i = list.size() - 1; i >= 0; i--) {
            cur.next = list.get(i);
            cur = cur.next;
        }
        return pre.next;
    }

    /**
     * 递归
     * 
     * 递归版本会复杂一些
     * 
     * @param head
     * @return
     */
    private ListNode extracted2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 迭代
     * 
     * @param head
     * @return
     */
    private ListNode extracted(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            // 找到临时便量
            ListNode temp = cur.next;
            // 指向正确的变量
            cur.next = pre;
            // pre 指向当前变量
            pre = cur;
            // 当前变量指向临时变量
            cur = temp;
        }
        return pre;

    }
}
// @lc code=end
