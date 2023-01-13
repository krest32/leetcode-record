import java.util.ArrayList;
import java.util.List;


import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 迭代
        // return extracted(head, left, right);

        // 使用 list 实现链表的反转，需要使用额外的空间
        // return extracted2(head, left, right);

        return test(head, left, right);
    }

    /**
     * 44/44 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 55.39 % of java submissions (39.2 MB)
     * 
     * @param head
     * @param left
     * @param right
     * @return
     */
    private ListNode extracted2(ListNode head, int left, int right) {
        ListNode pre = new ListNode(-1, head);
        ListNode leftHead = pre;
        for (int i = 1; i < left; i++) {
            leftHead = leftHead.next;
        }

        ListNode cur = leftHead.next;
        List<ListNode> ans = new ArrayList<>();

        for (int i = 0; i < right - left + 1; i++) {
            ans.add(cur);
            cur = cur.next;
            ans.get(i).next = null;
        }

        for (int i = ans.size() - 1; i >= 0; i--) {
            leftHead.next = ans.get(i);
            leftHead = leftHead.next;
        }

        leftHead.next = cur;
        return pre.next;
    }

    private ListNode test(ListNode head, int left, int right) {
        ListNode pre = new ListNode(-1, head);
        ListNode leftHead = pre;
        for (int i = 1; i < left; i++) {
            leftHead = leftHead.next;
        }

        ListNode cur = leftHead.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = leftHead.next;
            leftHead.next = temp;
        }
        return pre.next;
    }

    /**
     * 44/44 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 94.23 % of java submissions (38.9 MB)
     * 
     * @param head
     * @param left
     * @param right
     * @return
     */
    private ListNode extracted(ListNode head, int left, int right) {
        ListNode pre = new ListNode(-1, head);
        ListNode leftNode = pre;
        // 先找到反转列表的开始的前一个节点
        for (int i = 1; i < left; i++) {
            leftNode = leftNode.next;
        }

        // 找到需要反转的开始节点进行操作
        ListNode cur = leftNode.next;
        // 开始反转列表

        for (int i = 0; i < right - left; i++) {
            // 找到下一个的节点;
            ListNode next = cur.next;
            // 将next节点分离开始，同时将cur.next指向next的下一个节点
            cur.next = next.next;
            // 将next的下一个next重新指向了left节点
            next.next = leftNode.next;
            // 将leftnode 的节点向下一个节点进行推移
            leftNode.next = next;
        }
        return pre.next;
    }
}
// @lc code=end
