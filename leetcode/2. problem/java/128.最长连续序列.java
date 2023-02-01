import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        // 哈希
        // return extracted(nums);

        // 1
        return test(nums);
    }

    private int test(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int tempNum = num;
                int cnt = 1;
                while (set.contains(tempNum + 1)) {
                    cnt++;
                    tempNum++;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }

    /**
     * 72/72 cases passed (279 ms)
     * Your runtime beats 7.59 % of java submissions
     * Your memory usage beats 65.19 % of java submissions (57.9 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // 需要先初始化集合数据
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int temp = nums[i];
                int flag = 1;
                while (set.contains(temp + 1)) {
                    flag++;
                    temp++;
                }
                num = Math.max(num, flag);
            }
        }
        return num;
    }
}
// @lc code=end
