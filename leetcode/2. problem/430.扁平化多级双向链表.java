import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=430 lang=java
 *
 * [430] 扁平化多级双向链表
 */

// @lc code=start

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

class Solution {
    public Node flatten(Node head) {
        // 迭代
        // dfs(head);
        // return head;

        // 集合
        return listAnswer(head);

    }

    /**
     * 26/26 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 83.45 % of java submissions (39.4 MB)
     * 
     * @param head
     * @return
     */
    private Node listAnswer(Node head) {
        if (head == null) {
            return head;
        }
        // 集合
        List<Node> nodeList = new ArrayList<>();
        testList(head, nodeList);
        // 节点指针置为 null
        for (Node curNode : nodeList) {
            curNode.child = null;
            curNode.next = null;
        }
        // 组合新的链表
        for (int i = 0; i < nodeList.size(); i++) {
            if (i != 0) {
                nodeList.get(i).prev = nodeList.get(i - 1);
            } else {
                nodeList.get(i).prev = null;
            }
            if (i != nodeList.size() - 1) {
                nodeList.get(i).next = nodeList.get(i + 1);
            } else {
                nodeList.get(i).next = null;
            }
        }
        return nodeList.get(0);
    }

    private void testList(Node head, List<Node> nodeList) {
        while (head != null) {
            nodeList.add(head);
            if (head.child != null) {
                testList(head.child, nodeList);
            }
            head = head.next;
        }
    }

    public Node dfs(Node node) {
        Node cur = node;
        // 记录链表的最后一个节点
        Node last = null;

        while (cur != null) {
            Node next = cur.next;
            // 如果有子节点，那么首先处理子节点
            if (cur.child != null) {
                Node childLast = dfs(cur.child);

                next = cur.next;
                // 将 node 与 child 相连
                cur.next = cur.child;
                cur.child.prev = cur;

                // 如果 next 不为空，就将 last 与 next 相连
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }
                // 将 child 置为空
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }
}
// @lc code=end
