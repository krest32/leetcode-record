import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import entrty.ListNode;

/*
 * @lc app=leetcode.cn id=1019 lang=java
 *
 * [1019] 链表中的下一个更大节点
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
    public int[] nextLargerNodes(ListNode head) {
        // 使用栈
        // return getIndex(head);

        // test
        // return test(head);
    }

    private int[] test(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        // 存入的是 链表的索引，内部维持一个递增的索引顺序
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        while (head != null) {
            int val = head.val;
            // 每次遇到更大的值，就取更新 list 中的内容
            while (!stack.isEmpty() && ans.get(stack.peek()) < val) {
                ans.set(stack.pop(), val);
            }
            stack.push(idx);
            ans.add(val);
            idx++;
            head = head.next;
        }
        while (!stack.isEmpty()) {
            ans.set(stack.pop(), 0);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private int[] getIndex(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        // 存入的是 链表的索引，内部维持一个递增的索引顺序
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        while (head != null) {
            int val = head.val;
            // 每次遇到更大的值，就取更新 list 中的内容
            while (!stack.isEmpty() && ans.get(stack.peek()) < val) {
                ans.set(stack.pop(), val);
            }
            // 先存入一个原始值
            stack.push(idx);
            ans.add(val);
            idx++;
            head = head.next;
        }
        while (!stack.isEmpty()) {
            ans.set(stack.pop(), 0);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end
