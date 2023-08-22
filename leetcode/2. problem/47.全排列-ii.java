import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 回溯
        // return extracted(nums);

        // test
        return test(nums);

    }

    private List<List<Integer>> test(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        backTrackTest(ans, vis, nums, new ArrayList<Integer>());
        return ans;
    }

    private void backTrackTest(List<List<Integer>> ans,
            boolean[] vis,
            int[] nums,
            ArrayList<Integer> tempArr) {
        if (tempArr.size() == nums.length) {
            ans.add(new ArrayList<>(tempArr));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (vis[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
                    continue;
                }
                vis[i] = true;
                tempArr.add(nums[i]);
                backTrackTest(ans, vis, nums, tempArr);
                tempArr.remove(tempArr.size() - 1);
                vis[i] = false;
            }
        }
    }

    /**
     * 33/33 cases passed (1 ms)
     * Your runtime beats 99.8 % of java submissions
     * Your memory usage beats 82.27 % of java submissions (42 MB)
     * 
     * @param nums
     * @return
     */
    private List<List<Integer>> extracted(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        backTracking(nums, ans, vis, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void backTracking(int[] nums,
            List<List<Integer>> ans,
            boolean[] vis,
            ArrayList<Integer> arr,
            int key) {
        // 递归终止条件
        if (arr.size() == nums.length) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 剪枝： 去掉自身以及一些用过的元素
                if (vis[i]) {
                    continue;
                }
                // 剪枝：保证相同的数字都相邻，然后每次填入的数一定是这个数
                // 所在重复数集合中「从左往右第一个未被填过的数字」
                if (i != key && nums[i] == nums[i - 1] && !vis[i - 1]) {
                    continue;
                }
                vis[i] = true;
                arr.add(nums[i]);
                backTracking(nums, ans, vis, arr, 0);
                arr.remove(arr.size() - 1);
                vis[i] = false;
            }
        }
    }
}
// @lc code=end
