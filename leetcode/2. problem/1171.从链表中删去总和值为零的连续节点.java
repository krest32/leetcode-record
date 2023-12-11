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

    /**
     * 105/105 cases passed (2 ms)
     * Your runtime beats 91.26 % of java submissions
     * Your memory usage beats 10.11 % of java submissions (42.3 MB)
     * 
     * @param head
     * @return
     */
    private ListNode extracted(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();

        int sum = 0;
        // 首次遍历建立 节点处链表和<->节点 哈希表
        // 若同一和出现多次会覆盖，即记录该sum出现的最后一次节点，会自然的取点和为0的节点
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            map.put(sum, d);
        }

        // 第二遍遍历 若当前节点处sum在下一处出现了则表明两结点之间所
        // 有节点和为0 直接删除区间所有节点
        sum = 0;
        for (ListNode d = dummy; d != null; d = d.next) {
            sum += d.val;
            d.next = map.get(sum).next;
        }

        return dummy.next;
    }
}
// @lc code=end
