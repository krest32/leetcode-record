/*
 * @lc app=leetcode.cn id=2024 lang=java
 *
 * [2024] 考试的最大困扰度
 */

// @lc code=start
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // 滑动窗口
        // return extracted(answerKey, k);

        // test
        return test(answerKey, k);
    }

    private int test(String answerKey, int k) {
        int len = answerKey.length();
        int numT = 0, numF = 0, left = 0, right = 0, ans = 0;
        while (right < len) {
            if (answerKey.charAt(right) == 'T') {
                numT++;
            } else {
                numF++;
            }
            while (numF > k && numT > k) {
                if (answerKey.charAt(left) == 'T') {
                    numT--;
                } else {
                    numF--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    /**
     * 93/93 cases passed (10 ms)
     * Your runtime beats 93.9 % of java submissions
     * Your memory usage beats 69.76 % of java submissions (41.7 MB)
     * 
     * @param answerKey
     * @param k
     * @return
     */
    private int extracted(String answerKey, int k) {
        int n = answerKey.length();
        char[] arr = answerKey.toCharArray();
        int left = 0;
        int right = 0;
        int numT = 0;
        int numF = 0;
        int ans = 0;
        while (right < n) {
            if (arr[right] == 'T') {
                numT++;
            } else {
                numF++;
            }
            while (numT > k && numF > k) {
                if (arr[left] == 'T') {
                    numT--;
                } else {
                    numF--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
// @lc code=end
