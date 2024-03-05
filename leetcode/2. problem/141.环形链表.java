import java.util.HashSet;
import java.util.Set;

import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 使用 o(1) 常量空间

        // 使用迭代方式 (快慢指针)--> 最优解
        // return extracted(head);

        // 使用额外内容Set处理
        // return extracted2(head);

        // test
        return test(head);
    }

    private boolean test(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 使用Set
     * 
     * Your runtime beats 22.43 % of java submissions
     * Your memory usage beats 43.9 % of java submissions (42.1 MB)
     */
    private boolean extracted2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 迭代
     * 
     * 22/22 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 11.64 % of java submissions (43 MB)
     * 
     * @param head
     * @return
     */
    private boolean extracted(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
// @lc code=end
