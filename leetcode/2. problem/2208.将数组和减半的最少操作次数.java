import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=2208 lang=java
 *
 * [2208] 将数组和减半的最少操作次数
 */

// @lc code=start
class Solution {
    public int halveArray(int[] nums) {
        // 使用优先队列实现减半操作
        // return extracted(nums);

        // test
        return test(nums);
    }

    private int test(int[] nums) {
        PriorityQueue<Double> queue = new PriorityQueue<>(
                new Comparator<Double>() {
                    @Override
                    public int compare(Double o1, Double o2) {
                        return Double.compare(o2, o1);
                    }
                });

        Double sum = 0d;
        for (int num : nums) {
            sum += num;
            queue.offer((double) num);
        }
        double half = sum / 2;
        int count = 0;
        while (sum > half && !queue.isEmpty()) {
            double halfNum = queue.poll() / 2;
            sum -= halfNum;
            queue.offer(halfNum);
            count++;
        }
        return count;
    }

    /**
     * 62/62 cases passed (184 ms)
     * Your runtime beats 26.53 % of java submissions
     * Your memory usage beats 89.91 % of java submissions (55 MB)
     * 
     * @param nums
     * @return
     */
    private int extracted(int[] nums) {

        PriorityQueue<Double> queue = new PriorityQueue<>(
                new Comparator<Double>() {
                    @Override
                    public int compare(Double o1, Double o2) {
                        return Double.compare(o2, o1);
                    }
                });

        Double sum = 0d;
        for (int num : nums) {
            sum += num;
            queue.offer((double) num);
        }
        double half = sum / 2;
        int count = 0;
        while (sum > half && !queue.isEmpty()) {
            double halfNum = queue.poll() / 2;
            sum -= halfNum;
            queue.offer(halfNum);
            count++;
        }
        return count;
    }
}
// @lc code=end
