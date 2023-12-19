import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=1669 lang=java
 *
 * [1669] 合并两个链表
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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // 迭代
        // return extracted(list1, a, b, list2);

        // test
        return test(list1, a, b, list2);
    }

    private ListNode test(ListNode list1, int a, int b, ListNode list2) {
        ListNode pre = new ListNode(-1, list1);
        b -= a;
        while (a > 1) {
            list1 = list1.next;
            a--;
        }
        ListNode right = list1;
        while (b > -1) {
            right = right.next;
            b--;
        }
        list1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = right.next;
        return pre.next;
    }

    /**
     * 61/61 cases passed (1 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 13.69 % of java submissions (45.4 MB)
     * 
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    private ListNode extracted(ListNode list1, int a, int b, ListNode list2) {
        ListNode pre = new ListNode(-1, list1);
        b -= a;
        while (a > 1) {
            list1 = list1.next;
            a--;
        }
        ListNode right = list1;
        while (b > -1) {
            right = right.next;
            b--;
        }
        list1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = right.next;
        return pre.next;

    }
}
// @lc code=end
