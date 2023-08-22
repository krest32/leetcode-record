/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 双指针
        // return extracted(numbers, target);

        // test
        return test(numbers, target);
    }

    private int[] test(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (right > left) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    /**
     * 23/23 cases passed (1 ms)
     * Your runtime beats 98.86 % of java submissions
     * Your memory usage beats 71.26 % of java submissions (44.1 MB)
     * 
     * @param numbers
     * @param target
     * @return
     */
    private int[] extracted(int[] numbers, int target) {
        // 双指针，定义左侧、右侧指针
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[] { i + 1, j + 1 };
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[0];
    }
}
// @lc code=end
