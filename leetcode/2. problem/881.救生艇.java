import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=881 lang=java
 *
 * [881] 救生艇
 */

// @lc code=start
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // 双指针
        // return extracted(people, limit);

        // test
        return test(people, limit);
    }

    private int test(int[] nums, int limit) {
        int ans = 0, len = nums.length;
        Arrays.sort(nums);
        int left = 0, right = len - 1;
        while (left <= right) {
            if (nums[left] + nums[right] <= limit) {
                left++;
            }
            right--;
            ans++;
        }
        return ans;
    }

    /**
     * 78/78 cases passed (19 ms)
     * Your runtime beats 8.24 % of java submissions
     * Your memory usage beats 8.24 % of java submissions (50 MB)
     * 
     * @param people
     * @param limit
     * @return
     */
    private int extracted(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                light++;
            }
            heavy--;
            ans++;
        }
        return ans;
    }
}
// @lc code=end
