import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // 回溯
        // return extracted(n, k);

        return test(n, k);

    }

    private List<List<Integer>> test(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrackingTest(ans, n, k, 1, new ArrayList<Integer>());
        return ans;
    }

    private void backTrackingTest(List<List<Integer>> ans, int n, int k, int key, ArrayList<Integer> arr) {
        if (arr.size() == k) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = key; i <= n; i++) {
                arr.add(i);
                backTrackingTest(ans, n, k, i + 1, arr);
                arr.remove(arr.size() - 1);
            }
        }
    }

    /**
     * 27/27 cases passed (10 ms)
     * Your runtime beats 58.58 % of java submissions
     * Your memory usage beats 69.72 % of java submissions (42.6 MB)
     * 
     * @param n
     * @param k
     * @return
     */
    private List<List<Integer>> extracted(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(n, k, ans, new ArrayList<Integer>(), 1);
        return ans;
    }

    private void backTracking(int n,
            int k,
            List<List<Integer>> ans,
            ArrayList<Integer> arr,
            int key) {
        if (arr.size() == k) {
            ans.add(new ArrayList<>(arr));
        } else {
            for (int i = key; i <= n; i++) {
                arr.add(i);
                backTracking(n, k, ans, arr, i + 1);
                arr.remove(arr.size() - 1);
            }
        }
    }
}
// @lc code=end
