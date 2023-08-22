/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        // 滑动窗口
        // return extracted(fruits);

        return test(fruits);

    }

    private int test(int[] fruits) {
        int len = fruits.length;
        if (len <= 2) {
            return len;
        }
        int left = 0;
        int right = 0;
        int[] cnt = new int[len];
        int count = 0;
        int ans = 2;
        while (right < len) {
            cnt[fruits[right]]++;
            if (cnt[fruits[right]] == 1) {
                count++;
            }
            right++;

            while (count > 2) {
                cnt[fruits[left]]--;
                if (cnt[fruits[left]] == 0) {
                    count--;
                }
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    /**
     * 91/91 cases passed (6 ms)
     * Your runtime beats 90.03 % of java submissions
     * Your memory usage beats 88.81 % of java submissions (49.2 MB)
     * 
     * @param fruits
     * @return
     */
    private int extracted(int[] fruits) {
        int n = fruits.length;
        if (n <= 2)
            return n;
        int ans = 2, left = 0, right = 0;
        int[] freq = new int[n];
        int count = 0;
        while (right < n) {
            freq[fruits[right]]++;
            if (freq[fruits[right]] == 1)
                count++;
            right++;
            while (count > 2) {
                freq[fruits[left]]--;
                if (freq[fruits[left]] == 0)
                    count--;
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}

// @lc code=end
