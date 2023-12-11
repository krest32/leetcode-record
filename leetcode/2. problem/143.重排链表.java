import java.util.ArrayList;
import java.util.List;

import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        // method1(head);

        // 迭代方法，但是太折腾了
        method2(head);
    }

    private void method2(ListNode head) {
        ListNode headCopy = head;
        ListNode l1Head = new ListNode(-1, headCopy);
        ListNode l1 = l1Head;
        ListNode l2Head = new ListNode(-1);

        ListNode fast = l1Head;
        while (fast.next != null && fast.next.next != null) {
            l1 = l1.next;
            fast = fast.next.next;
        }
        // 去掉链表中的环
        l2Head.next = l1.next;
        l1.next = null;
        ListNode l3 = revrse(l2Head.next);
        head = connect(l1Head.next, l3);
    }

    private ListNode revrse(ListNode head) {
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

    private ListNode connect(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        int flag = 0;
        while (l1 != null || l2 != null) {
            if (flag % 2 == 0 && l1 != null) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
            flag++;
        }
        cur.next = null;
        return pre.next;
    }

    private void method1(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        if (head == null)
            return;
        ListNode node = head;
        // 节点全部加入到List中，同时将下一个指针空
        while (node != null) {
            list.add(node);
            node = node.next;
        }

        int j = list.size() - 1;
        int i = 0;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j)
                break;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
// @lc code=end
