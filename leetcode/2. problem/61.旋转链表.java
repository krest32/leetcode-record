import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {

        // 迭代
        // return extracted(head, k);

        // 1
        return test(head, k);
    }

    private ListNode test(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            len++;
        }
        k = len - k % len;
        if (k == len) {
            return head;
        }

        // 拼接形成一个环形列表
        cur.next = head;
        while (k > 0) {
            cur = cur.next;
            k--;
        }
        ListNode ret = cur.next;
        cur.next = null;
        return ret;

    }

    private ListNode extracted(ListNode head, int k) {
        // 判断特殊情况
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int len = 1;
        ListNode pre = head;
        while (pre.next != null) {
            pre = pre.next;
            len++;
        }

        // 处理k, 避免多转
        k = len - k % len;
        if (k == len) {
            return head;
        }

        pre.next = head;
        while (k > 0) {
            pre = pre.next;
            k--;
        }
        ListNode ret = pre.next;
        pre.next = null;
        return ret;
    }
}
// @lc code=end
