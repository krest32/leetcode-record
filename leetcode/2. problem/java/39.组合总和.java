import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 回溯
        // return extracted(candidates, target);

        // test
        return test(candidates, target);
    }

    private List<List<Integer>> test(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(ans, candidates, target, 0, new ArrayList<Integer>());
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, int[] candidates, int target, int key, ArrayList<Integer> arr) {
        if (target == 0) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = key; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    arr.add(candidates[i]);
                    // 传入 i, 确认元素可以重复使用
                    backTrack(ans, candidates, target - candidates[i], i, arr);
                    arr.remove(arr.size() - 1);
                }
            }
        }

    }

    /**
     * 160/160 cases passed (1 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 69.46 % of java submissions (41.7 MB)
     * 
     * @param candidates
     * @param target
     * @return
     */
    private List<List<Integer>> extracted(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res,
            ArrayList<Integer> temp, int idx) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = idx; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    temp.add(candidates[i]);
                    // 此处传入i,代表仅使用数组后面的元素
                    dfs(candidates, target - candidates[i], res, temp, i);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
// @lc code=end
