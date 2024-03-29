/*
 * @lc app=leetcode.cn id=1131 lang=java
 *
 * [1131] 绝对值表达式的最大值
 */

// @lc code=start
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int amin = Integer.MAX_VALUE, bmin = Integer.MAX_VALUE;
        int cmin = Integer.MAX_VALUE, dmin = Integer.MAX_VALUE;
        int amax = Integer.MIN_VALUE, bmax = Integer.MIN_VALUE;
        int cmax = Integer.MIN_VALUE, dmax = Integer.MIN_VALUE;

        for(int i = 0; i < arr1.length; i++) {
            amin = Math.min(amin, arr1[i]+arr2[i]+i);
            amax = Math.max(amax, arr1[i]+arr2[i]+i);

            bmin = Math.min(bmin, arr1[i]+arr2[i]-i);
            bmax = Math.max(bmax, arr1[i]+arr2[i]-i);

            cmin = Math.min(cmin, arr1[i]-arr2[i]+i);
            cmax = Math.max(cmax, arr1[i]-arr2[i]+i);

            dmin = Math.min(dmin, arr1[i]-arr2[i]-i);
            dmax = Math.max(dmax, arr1[i]-arr2[i]-i);
        }
        return Math.max(Math.max(amax-amin, bmax-bmin), Math.max(cmax-cmin, dmax-dmin));
    }
}
// @lc code=end

