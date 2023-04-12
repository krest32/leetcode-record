import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 回溯
        // return extracted2(nums);

        return test(nums);
    }

    private List<List<Integer>> test(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        backTrackTest(ans, nums, new ArrayList<>(), vis);
        return ans;
    }

    private void backTrackTest(List<List<Integer>> ans,
            int[] nums,
            List<Integer> tempArr,
            boolean[] vis) {
        if (tempArr.size() == nums.length) {
            ans.add(new ArrayList<>(tempArr));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!vis[i]) {
                    vis[i] = true;
                    tempArr.add(nums[i]);
                    backTrackTest(ans, nums, tempArr, vis);
                    tempArr.remove(tempArr.size() - 1);
                    vis[i] = false;
                }
            }
        }
    }

    /**
     * 26/26 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 70.51 % of java submissions (41.5 MB)
     * 
     * @param nums
     * @return
     */
    private List<List<Integer>> extracted2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        bckTra(ans, nums, new ArrayList<Integer>(), vis);
        return ans;
    }

    private void bckTra(
            List<List<Integer>> ans,
            int[] nums,
            ArrayList<Integer> arr,
            boolean[] vis) {
        if (arr.size() == nums.length) {
            ans.add(new ArrayList<>(arr));
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            arr.add(nums[i]);
            bckTra(ans, nums, arr, vis);
            arr.remove(arr.size() - 1);
            vis[i] = false;
        }
    }
}
// @lc code=end
