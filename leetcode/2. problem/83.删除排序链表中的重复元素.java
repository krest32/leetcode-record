
import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 迭代
        // return extracted(head);

        // 2
        return test(head);

    }

    private ListNode test(ListNode head) {
        ListNode pre = new ListNode(-101, head);
        ListNode cur = pre;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }

    /**
     * 166/166 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 80.18 % of java submissions (40.8 MB)
     * 
     * @param head
     * @return
     */
    private ListNode extracted(ListNode head) {
        ListNode pre = new ListNode(-101, head);
        ListNode cur = pre;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }
}
// @lc code=end
