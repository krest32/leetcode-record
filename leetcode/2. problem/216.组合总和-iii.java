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
        backTrackTest(ans, k, n, new ArrayList<Integer>(), 0, 1);
        return ans;
    }

    private void backTrackTest(
            List<List<Integer>> ans,
            int k, int n,
            ArrayList<Integer> tempArr,
            int sum, int idx) {
        if (sum == n && k == tempArr.size()) {
            ans.add(new ArrayList<>(tempArr));
        } else {
            for (int i = idx; i <= 9; i++) {
                if (sum + i <= n) {
                    sum += i;
                    tempArr.add(i);
                    backTrackTest(ans, k, n, tempArr, sum, i + 1);
                    sum -= i;
                    tempArr.remove(tempArr.size() - 1);
                }
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
