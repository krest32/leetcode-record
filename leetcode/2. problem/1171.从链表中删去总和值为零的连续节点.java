import java.util.HashMap;
import java.util.Map;

import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=1171 lang=java
 *
 * [1171] 从链表中删去总和值为零的连续节点
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
    public ListNode removeZeroSumSublists(ListNode head) {
        // 迭代
        // return extracted(head);

        // test
        return test(head);
    }

    private ListNode test(ListNode head) {
        ListNode pre = new ListNode(-1, head);
        ListNode cur = pre;
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        while (cur != null) {
            sum += cur.val;
            map.put(sum, cur);
            cur = cur.next;
        }

        cur = pre;
        sum = 0;
        while (cur != null) {
            sum += cur.val;
            cur.next = map.get(sum).next;
            cur = cur.next;
        }
        return pre.next;
    }

    /**
     * 105/105 cases passed (2 ms)
     * Your runtime beats 92.02 % of java submissions
     * Your memory usage beats 9.97 % of java submissions (42.4 MB)
     * 
     * @param head
     * @return
     */
    private ListNode extracted(ListNode head) {
        ListNode pre = new ListNode(-1, head);
        Map<Integer, ListNode> map = new HashMap<>();

        int sum = 0;
        ListNode cur = pre;
        while (cur != null) {
            sum += cur.val;
            map.put(sum, cur);
            cur = cur.next;
        }

        sum = 0;
        cur = pre;
        while (cur != null) {
            sum += cur.val;
            cur.next = map.get(sum).next;
            cur = cur.next;
        }
        return pre.next;
    }
}
// @lc code=end
