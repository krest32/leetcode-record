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
        return extracted(candidates, target);
        
        // test
        // return test(candidates, target);
    }


    private List<List<Integer>> test(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrackTest(ans, candidates, target, 0, 0, new ArrayList<>());
        return ans;
    }

    private void backTrackTest(List<List<Integer>> ans,
            int[] candidates,
            int target,
            int idx,
            int sum,
            List<Integer> tempList) {
        if (sum == target) {
            ans.add(new ArrayList<>(tempList));
        } else {
            for (int i = idx; i < candidates.length; i++) {
                int num = candidates[i];
                if (sum + num <= target) {
                    sum += num;
                    tempList.add(num);
                    backTrackTest(ans, candidates, target, i, sum, tempList);
                    sum -= num;
                    tempList.remove(tempList.size() - 1);
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

    private void dfs(int[] candidates,
            int target,
            List<List<Integer>> res,
            ArrayList<Integer> temp,
            int idx) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = idx; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    temp.add(candidates[i]);
                    dfs(candidates, target - candidates[i], res, temp, i);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}
// @lc code=end
