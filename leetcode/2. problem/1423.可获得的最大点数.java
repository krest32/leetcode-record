import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1423 lang=java
 *
 * [1423] 可获得的最大点数
 */

// @lc code=start
class Solution {
    // 转变思路：找到长度为n-k的最小连续子数和
    public int maxScore(int[] cardPoints, int k) {
        // 滑动窗口
        // return extracted(cardPoints, k);

        // 贪心？求解不正确
        return test2(cardPoints, k);

        // test
        // return test(cardPoints, k);
    }


    /**
     * 40/40 cases passed (2 ms)
     * Your runtime beats 71.71 % of java submissions
     * Your memory usage beats 40.3 % of java submissions (50.1 MB)
     * 
     * @param cardPoints
     * @param k
     * @return
     */
    private int test(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int minSum = 0;
        int total = 0;
        // 初始化窗口
        for (int i = 0; i < len - k; i++) {
            minSum += cardPoints[i];
        }
        // 获取最小的minSum
        int sum = minSum;
        total = minSum;
        for (int i = len - k; i < len; i++) {
            sum = sum + cardPoints[i] - cardPoints[i - len + k];
            minSum = Math.min(sum, minSum);
            total += cardPoints[i];
        }

        return total - minSum;
    }

    /**
     * 16/40 cases passed (N/A)
     * 
     * [11,49,100,20,86,29,72]
     * 4
     * 
     * @param cardPoints
     * @param k
     * @return
     */
    private int test2(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int left = 0, right = len - 1;
        int sum = 0;
        while (k > 0) {
            int num = 0;
            if (cardPoints[left] > cardPoints[right]) {
                num = cardPoints[left];
                left++;
            } else {
                num = cardPoints[right];
                right--;
            }
            sum += num;
            k--;
        }
        return sum;
    }



    /**
     * 40/40 cases passed (5 ms)
     * Your runtime beats 30.59 % of java submissions
     * Your memory usage beats 16.78 % of java submissions (50.5 MB)
     * 
     * @param cardPoints
     * @param k
     * @return
     */
    private int extracted(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSize = n - k;
        int sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += cardPoints[i];
        }
        int minSum = sum;
        for (int i = windowSize; i < n; i++) {
            sum += cardPoints[i] - cardPoints[i - windowSize];
            minSum = Math.min(minSum, sum);
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }
}
// @lc code=end
