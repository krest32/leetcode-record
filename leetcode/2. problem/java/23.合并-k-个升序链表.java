/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start

import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        // 顺序排列
        // return answer1(lists);
        // 使用优先队列
        // return answer3(lists);

        // 分治思想
        // return answer2(lists);

        // test
        return test(lists);
    }

    /**
     * 测试
     * 
     * @param lists
     * @return
     */
    private ListNode test(ListNode[] lists) {
        return mergeTest(lists, 0, lists.length - 1);
    }

    private ListNode mergeTest(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (right + left) / 2;
        return mergeNode(mergeTest(lists, left, mid), mergeTest(lists, mid + 1, right));
    }

    /**
     * 使用优先队列（堆）
     * 
     * @param lists
     * @return
     */
    private ListNode answer3(ListNode[] lists) {
        PriorityQueue<Status> queue = new PriorityQueue<>();
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (!queue.isEmpty()) {
            Status temp = queue.poll();
            cur.next = temp.ptr;
            cur = cur.next;
            if (temp.ptr.next != null) {
                queue.offer(new Status(temp.ptr.next.val, temp.ptr.next));
            }
        }

        return head.next;
    }

    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        // 按照从小到大的顺序进行排列
        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    /**
     * 分治合并
     * 
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 32.5 % of java submissions (43.2 MB)
     * 
     * @param lists
     * @return
     */
    private ListNode answer2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 分治的基础方法,将每个部分进行拆分
     * 
     * @param lists
     * @param i
     * @param j
     * @return
     */
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;

        return mergeNode(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    /**
     * 顺序合并
     * 
     * Your runtime beats 10.27 % of java submissions
     * Your memory usage beats 16.96 % of java submissions (43.4 MB)
     * 
     * @param lists
     * @return
     */
    private ListNode answer1(ListNode[] lists) {
        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            res = mergeNode(res, lists[i]);
        }
        return res;
    }

    private ListNode mergeNode(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                cur.next = l1;
                l1 = l1.next;
            } else if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        return pre.next;
    }
}
// @lc code=end
