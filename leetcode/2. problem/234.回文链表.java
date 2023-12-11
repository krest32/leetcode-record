import java.util.ArrayList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

import entrty.ListNode;

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
    public boolean isPalindrome(ListNode head) {
        // 使用额外空间会更加简单，
        // 虽然可以用过快慢指针的方式找到中间节点，但是实现方法过于繁琐

        // list 首尾双指针
        return extracted(head);
    }

    /**
     * 首尾双指针
     * 
     * @param head
     * @return
     */
    private boolean extracted(ListNode head) {
        /**
         * 用list封装链表，然后通过双指针，
         * 判断链表是否是回文链表
         */
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            if (list.get(start) != list.get(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
// @lc code=end
