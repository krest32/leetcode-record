import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉 K 位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        // 原理：如果当前的数字后一个数字大，那么就移除当前的数字

        // 双端队列
        // return extracted(num, k);

        // 1
        return test(num, k);
    }

    private String test(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        if (k > 0) {
            for (int i = k; i > 0; i--) {
                deque.pollLast();
            }
        }

        StringBuilder ans = new StringBuilder();
        boolean isZeroLeading = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (isZeroLeading && digit == '0') {
                continue;
            }
            isZeroLeading = false;
            ans.append(digit);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }

    /**
     * 43/43 cases passed (11 ms)
     * Your runtime beats 71.56 % of java submissions
     * Your memory usage beats 33.31 % of java submissions (42.9 MB)
     * 
     * @param num
     * @param k
     * @return
     */
    private String extracted(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            // 当遇到下一个字符比队列中的字符大的时候，就移除当前队列中的字符
            while (!deque.isEmpty() && k > 0
                    && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        // 如果 K!=0,移除尾巴的元素
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
// @lc code=end
