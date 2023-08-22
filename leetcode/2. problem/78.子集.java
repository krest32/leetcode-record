import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // 回溯
        // return extracted(nums);

        // 测试
        return test(nums);
    }

    private List<List<Integer>> test(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrackingTest(ans, nums, 0, new ArrayList<Integer>());
        return ans;
    }

    private void backTrackingTest(List<List<Integer>> ans, int[] nums, int key, ArrayList<Integer> arr) {
        ans.add(new ArrayList<>(arr));
        for (int i = key; i < nums.length; i++) {
            arr.add(nums[i]);
            backTracking(nums, ans, arr, i + 1);
            arr.remove(arr.size() - 1);
        }

    }

    /**
     * 10/10 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 83.31 % of java submissions (41.3 MB)
     * 
     * @param nums
     * @return
     */
    private List<List<Integer>> extracted(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(nums, ans, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void backTracking(int[] nums,
            List<List<Integer>> ans,
            ArrayList<Integer> arr,
            int key) {
        ans.add(new ArrayList<>(arr));
        for (int i = key; i < nums.length; i++) {
            arr.add(nums[i]);
            backTracking(nums, ans, arr, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}
// @lc code=end
