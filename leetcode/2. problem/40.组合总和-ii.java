import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 回溯
        // return extracted(candidates, target);

        return test(candidates, target);

    }

    private List<List<Integer>> test(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backTrackTest(ans, candidates, target, 0, 0, new ArrayList<Integer>());
        return ans;
    }

    private void backTrackTest(List<List<Integer>> ans,
            int[] candidates,
            int target,
            int idx,
            int sum,
            List<Integer> temArr) {
        if (sum == target) {
            ans.add(new ArrayList<>(temArr));
        } else {
            for (int i = idx; i < candidates.length; i++) {
                int num = candidates[i];
                if (i > 0 && candidates[i - 1] == candidates[i] && i != idx) {
                    continue;
                }
                if (sum + num <= target) {
                    sum += num;
                    temArr.add(num);
                    backTrackTest(ans, candidates, target, i + 1, sum, temArr);
                    sum -= num;
                    temArr.remove(temArr.size() - 1);
                }
            }
        }
    }

    /**
     * 176/176 cases passed (2 ms)
     * Your runtime beats 99.79 % of java submissions
     * Your memory usage beats 30.32 % of java submissions (42 MB)
     * 
     * @param candidates
     * @param target
     * @return
     */
    private List<List<Integer>> extracted(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(candidates, target, ans, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void backTracking(int[] candidates,
            int target,
            List<List<Integer>> ans,
            ArrayList<Integer> arr,
            int key) {
        if (target == 0) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = key; i < candidates.length; i++) {
                // 剪枝，如果当前数字与上一个数字相同，去掉其他匹配项
                if (i != key && candidates[i - 1] == candidates[i]) {
                    continue;
                }
                if (candidates[i] <= target) {
                    arr.add(candidates[i]);
                    backTracking(candidates, target - candidates[i], ans, arr, i + 1);
                    arr.remove(arr.size() - 1);
                }
            }
        }

    }
}
// @lc code=end
