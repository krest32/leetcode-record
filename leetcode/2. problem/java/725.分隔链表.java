
import java.util.List;

import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
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
    public ListNode[] splitListToParts(ListNode head, int k) {
        // 迭代
        // return extracted(head, k);

        // test
        return test(head, k);
    }

    private ListNode[] test(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        // 获取列表长度
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int size = len / k, remainder = len % k;
        ListNode[] ans = new ListNode[k];
        ListNode cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            ans[i] = cur;
            int partSize = size + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ans;
    }

    /**
     * 43/43 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 46.87 % of java submissions (41.5 MB)
     * 
     * @param head
     * @param k
     * @return
     */
    private ListNode[] extracted(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        // 计算链表的节点个数
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int quotient = n / k, remainder = n % k;
        ListNode[] parts = new ListNode[k];
        ListNode cur = head;
        for (int i = 0; i < k && cur != null; i++) {
            parts[i] = cur;
            int partSize = quotient + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;

        }
        return parts;
    }
}
// @lc code=end
