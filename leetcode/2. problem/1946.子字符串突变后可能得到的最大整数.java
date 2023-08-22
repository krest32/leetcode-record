/*
 * @lc app=leetcode.cn id=1946 lang=java
 *
 * [1946] 子字符串突变后可能得到的最大整数
 */

// @lc code=start
class Solution {
    public String maximumNumber(String num, int[] change) {

        return extracted(num, change);
    }

    /**
     * 279/279 cases passed (8 ms)
     * Your runtime beats 84.3 % of java submissions
     * Your memory usage beats 79.34 % of java submissions (42.1 MB)
     * 
     * @param num
     * @param change
     * @return
     */
    private String extracted(String num, int[] change) {
        boolean flag = false;
        // 转化为数组，只能够改变连续的区间
        char[] chArr = num.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            int temp = chArr[i] - '0';
            if (flag && temp > change[temp]) {
                break;
            }
            if (temp < change[temp]) {
                chArr[i] = (char) ('0' + change[temp]);
                flag = true;
            }
        }
        return new String(chArr);
    }
}
// @lc code=end
