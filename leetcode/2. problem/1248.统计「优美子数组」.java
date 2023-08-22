/*
 * @lc app=leetcode.cn id=1248 lang=java
 *
 * [1248] 统计「优美子数组」
 */

// @lc code=start
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // 滑动窗口
        // return extracted(nums, k);

        // 动态滑动窗口
        return extracted2(nums, k);

    }

    /**
     * 38/38 cases passed (9 ms)
     * Your runtime beats 54.94 % of java submissions
     * Your memory usage beats 73.43 % of java submissions (48.9 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    private int extracted2(int[] nums, int k) {
        int len = nums.length;
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0, ans = 0;
        while (right < len) {
            if (nums[right] % 2 == 1) {
                sum1++;
                sum2++;
            }
            while (left1 <= right && sum1 > k) {
                if (nums[left1] % 2 == 1) {
                    sum1--;
                }
                left1++;
            }
            while (left2 <= right && sum2 >= k) {
                if (nums[left2] % 2 == 1) {
                    sum2--;
                }
                left2++;
            }
            ans += left2 - left1;
            right++;
        }
        return ans;
    }

    /**
     * Your runtime beats 57.72 % of java submissions
     * Your memory usage beats 59.19 % of java submissions (48.8 MB)
     * 
     * @param nums
     * @param k
     * @return
     */
    private int extracted(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int oddCnt = 0;
        int res = 0;
        int len = nums.length;
        while (right < len) {
            if ((nums[right++] % 2) == 1) {
                // 记录窗口内奇数的个数
                oddCnt++;
            }

            if (oddCnt == k) {
                int tmp = right;
                // 找到下一个戒指奇数的位置
                while (right < len && (nums[right] % 2) == 0) {
                    right++;
                }
                int rightEvenCnt = right - tmp;
                // leftEvenCnt 即为第 1 个奇数左边的偶数的个数
                int leftEvenCnt = 0;
                while ((nums[left] % 2) == 0) {
                    leftEvenCnt++;
                    left++;
                }

                res += (leftEvenCnt + 1) * (rightEvenCnt + 1);
                // 此时 left 指向的是第 1 个奇数，因为该区间已经统计完了，因此 left 右移一位，oddCnt--
                left++;
                oddCnt--;
            }
        }
        return res;
    }
}
// @lc code=end
