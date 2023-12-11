import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=2181 lang=java
 *
 * [2181] 合并零之间的节点
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
    public ListNode mergeNodes(ListNode head) {
        // 迭代
        // return extracted(head);

        return test(head);
    }

    private ListNode test(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (head.next != null) {
            if (head.val == 0) {
                head = head.next;
                ListNode temp = new ListNode(head.val);
                while (head.val != 0) {
                    head = head.next;
                    temp.val = temp.val + head.val;
                }
                cur.next = temp;
                cur = cur.next;
            }
        }
        return pre.next;
    }

    private ListNode extracted(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        // 注意需要从head.next开始判断
        while (head.next != null) {
            if (head.val == 0) {
                head = head.next;
                ListNode temp = new ListNode(head.val);
                while (head.val != 0) {
                    head = head.next;
                    temp.val = temp.val + head.val;
                }
                cur.next = temp;
                cur = cur.next;
            }
        }
        return pre.next;
    }
}
// @lc code=end
