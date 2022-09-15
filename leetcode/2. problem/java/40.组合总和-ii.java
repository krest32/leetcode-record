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
        // 因为存在重复数字,所以先进行排序
        Arrays.sort(candidates);
        backTackingTest(candidates, target, new ArrayList<Integer>(), 0, ans);
        return ans;
    }

    private void backTackingTest(int[] candidates, int target, ArrayList<Integer> arr, int key,
            List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = key; i < candidates.length; i++) {
                // 此处的剪枝设计很微妙,需要细细思考
                if (i != key && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if (candidates[i] <= target) {
                    arr.add(candidates[i]);
                    backTackingTest(candidates, target - candidates[i], arr, i + 1, ans);
                    arr.remove(arr.size() - 1);
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
