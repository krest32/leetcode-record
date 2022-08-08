import java.lang.reflect.Array;
import java.sql.RowId;

/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {

    /**
     * 16/16 cases passed (1788 ms)
     * Your runtime beats 5 % of java submissions
     * Your memory usage beats 4.99 % of java submissions (74.6 MB)
     */
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public void update(int index, int val) {
        if (index >= nums.length) {
            // 方案1：
            // int[] temp = nums.clone();
            // nums = new int[index + 1];
            // for (int i = 0; i < temp.length; i++) {
            // nums[i] = temp[i];
            // }

            // 方案 2
            int[] temp = new int[index + 1];
            System.arraycopy(nums, 0, temp, 0, nums.length - 1);
            nums = temp;
        }
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end
