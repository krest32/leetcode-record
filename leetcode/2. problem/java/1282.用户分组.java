import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1282 lang=java
 *
 * [1282] 用户分组
 */

// @lc code=start
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // 哈希实现
        // return extracted(groupSizes);

        // test
        return test(groupSizes);
    }

    private List<List<Integer>> test(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = groupSizes[i];
            List<Integer> tempList = map.getOrDefault(num, new ArrayList<>());
            if (tempList.size() < num) {
                tempList.add(i);
                if (tempList.size() == num) {
                    ans.add(new ArrayList<>(tempList));
                    List<Integer> newList = new ArrayList<>();
                    map.put(num, newList);
                } else {
                    map.put(num, tempList);
                }
            }
        }
        return ans;
    }

    /**
     * 103/103 cases passed (7 ms)
     * Your runtime beats 48.76 % of java submissions
     * Your memory usage beats 5.38 % of java submissions (42.4 MB)
     * 
     * @param groupSizes
     * @return
     */
    private List<List<Integer>> extracted(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int idx = groupSizes[i];
            List<Integer> temp = map.getOrDefault(idx, new ArrayList<>());
            if (temp.size() < idx) {
                temp.add(i);
                if (temp.size() == idx) {
                    ans.add(new ArrayList<>(temp));
                    List<Integer> newList = new ArrayList<>();
                    map.put(idx, newList);
                } else {
                    map.put(idx, temp);
                }
            }
        }
        return ans;
    }
}
// @lc code=end
