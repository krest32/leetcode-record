import java.util.LinkedList;
import java.util.Queue;

import entrty.Node;

/**
 * @lc app=leetcode.cn id=116 lang=java
 *
 *     [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
 * // Definition for a Node.
 * class Node {
 * public int val;
 * public Node left;
 * public Node right;
 * public Node next;
 * 
 * public Node() {}
 * 
 * public Node(int _val) {
 * val = _val;
 * }
 * 
 * public Node(int _val, Node _left, Node _right, Node _next) {
 * val = _val;
 * left = _left;
 * right = _right;
 * next = _next;
 * }
 * };
 */

class Solution {
    public Node connect(Node root) {
        // 层次遍历
        // return extracted(root);

        // test
        return test(root);
    }

    private Node test(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    /**
     * 59/59 cases passed (3 ms)
     * Your runtime beats 30.03 % of java submissions
     * Your memory usage beats 96.86 % of java submissions (41.2 MB)
     * 
     * @param root
     * @return
     */
    private Node extracted(Node root) {
        if (root == null) {
            return root;
        }
        // 广度优先遍历二叉树
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                // 遍历过程中为next添加指针坐标
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        // 返回根节点
        return root;
    }
}
// @lc code=end
