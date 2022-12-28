import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 回溯
        // return extracted(k, n);

        // test
        return test(k, n);

    }

    private List<List<Integer>> test(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrackingTest(n, k, ans, new ArrayList<Integer>(), 1);
        return ans;
    }

    private void backTrackingTest(int sum, int k,
            List<List<Integer>> ans, ArrayList<Integer> arr, int key) {
        if (sum == 0 && arr.size() == k) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = key; i <= 9; i++) {
                arr.add(i);
                backTrackingTest(sum - i, k, ans, arr, i + 1);
                arr.remove(arr.size() - 1);
            }
        }
    }

    /**
     * 18/18 cases passed (0 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 37.65 % of java submissions (39.2 MB)
     * 
     * @param k
     * @param n
     * @return
     */
    private List<List<Integer>> extracted(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(n, k, ans, new ArrayList<Integer>(), 1);
        return ans;
    }

    private void backTracking(int sum,
            int k,
            List<List<Integer>> ans,
            ArrayList<Integer> arr,
            int idx) {
        if (sum == 0 && k == arr.size()) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = idx; i <= 9; i++) {
                arr.add(i);
                backTracking(sum - i, k, ans, arr, i + 1);
                arr.remove(arr.size() - 1);

            }
        }
    }
}
// @lc code=end
