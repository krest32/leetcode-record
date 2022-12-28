import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 回溯 + 减枝
        // return extracted(nums);

        // test
        return test(nums);
    }

    private List<List<Integer>> test(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backTrackingTest(ans, nums, 0, new ArrayList<Integer>());
        return ans;
    }

    private void backTrackingTest(List<List<Integer>> ans, int[] nums, int key, ArrayList<Integer> arr) {
        ans.add(new ArrayList<>(arr));
        for (int i = key; i < nums.length; i++) {
            if (i != key && nums[i] == nums[i - 1]) {
                continue;
            }
            arr.add(nums[i]);
            backTrackingTest(ans, nums, i + 1, arr);
            arr.remove(arr.size() - 1);
        }
    }

    /**
     * 20/20 cases passed (1 ms)
     * Your runtime beats 99.67 % of java submissions
     * Your memory usage beats 80.97 % of java submissions (41.5 MB)
     * 
     * @param nums
     * @return
     */
    private List<List<Integer>> extracted(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(nums, ans, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void backTracking(int[] nums,
            List<List<Integer>> ans,
            ArrayList<Integer> arr,
            int key) {
        ans.add(new ArrayList<>(arr));
        for (int i = key; i < nums.length; i++) {
            if (i != key && nums[i] == nums[i - 1]) {
                continue;
            }
            arr.add(nums[i]);
            backTracking(nums, ans, arr, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}
// @lc code=end
