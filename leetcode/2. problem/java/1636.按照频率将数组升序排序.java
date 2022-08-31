import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1636 lang=java
 *
 * [1636] 按照频率将数组升序排序
 */

// @lc code=start
class Solution {
    public int[] frequencySort(int[] nums) {
        return extracted(nums);
    }

    /**
     * 180/180 cases passed (7 ms)
     * Your runtime beats 41.05 % of java submissions
     * Your memory usage beats 54.74 % of java submissions (41.7 MB)
     * 
     * @param nums
     * @return
     */
    private int[] extracted(int[] nums) {
        // 统计每个数字的频率
        int[] frequency = new int[201];
        for (int i = 0; i < nums.length; i++) {
            frequency[nums[i] + 100]++;
        }
        // int数组的arrays.sort难以自定义排序，所以转换成Integer装箱类
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (frequency[o1 + 100] != frequency[o2 + 100]) {
                    return frequency[o1 + 100] - frequency[o2 + 100];
                } else {
                    return o2 - o1;
                }
            }
        });
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
// @lc code=end
