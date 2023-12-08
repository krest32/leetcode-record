import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import entrty.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        // 队列实现层次遍历
        // return extracted(root);

        return test(root);
    }

    private List<List<Integer>> test(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempAns = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                tempAns.add(node.val);
                List<Node> children = node.children;
                for (int j = 0; j < children.size(); j++) {
                    if (children.get(j) != null) {
                        queue.offer(children.get(j));
                    }
                }
            }
            ans.add(tempAns);
        }

        return ans;
    }

    /**
     * 
     * 38/38 cases passed (3 ms)
     * Your runtime beats 89.17 % of java submissions
     * Your memory usage beats 19.79 % of java submissions (43.3 MB)
     * 
     * @param root
     * @return
     */
    private List<List<Integer>> extracted(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);
                List<Node> childs = node.children;
                for (int j = 0; j < childs.size(); j++) {
                    if (childs.get(j) != null) {
                        queue.offer(childs.get(j));
                    }
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
// @lc code=end
