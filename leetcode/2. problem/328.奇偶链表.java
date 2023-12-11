import java.util.ArrayList;
import java.util.List;

import entrty.ListNode;

/**
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        // 使用额外空间
        // return method1(head);

        // 链表迭代
        return method2(head);
    }

    /**
     * 70/70 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 6.08 % of java submissions (42.5 MB)
     * 
     * @param head
     * @return
     */
    private ListNode method2(ListNode head) {
        ListNode evenHead = new ListNode(-1);
        ListNode even = evenHead;
        ListNode oddHead = new ListNode(-1);
        ListNode odd = oddHead;
        int flag = 0;
        while (head != null) {
            if (flag % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
            flag++;
        }
        odd.next = null;
        even.next = oddHead.next;
        return evenHead.next;
    }

    private ListNode method1(ListNode head) {
        // 奇数
        List<ListNode> odd = new ArrayList<>();
        // 偶数
        List<ListNode> idd = new ArrayList<>();
        boolean flag = true;
        while (head != null) {
            if (flag) {
                odd.add(head);
            } else {
                idd.add(head);
            }
            head = head.next;
            flag = !flag;
        }

        for (int i = 0; i < odd.size(); i++) {
            odd.get(i).next = null;
        }
        for (int i = 0; i < idd.size(); i++) {
            idd.get(i).next = null;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        int m = odd.size();
        int n = idd.size();

        for (int j = 0; j < m; j++) {
            cur.next = odd.get(j);
            cur = cur.next;
        }
        for (int j = 0; j < n; j++) {
            cur.next = idd.get(j);
            cur = cur.next;
        }
        return pre.next;
    }
}
// @lc code=end
