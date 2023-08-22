/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 贪心
        return extracted(flowerbed, n);
    }

    private boolean extracted(int[] flowerbed, int n) {
        int index = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int left = i == 0 ? 0 : flowerbed[i - 1];
                int right = i == (flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                if (left == 0 && right == 0) {
                    flowerbed[i] = 1;
                    index++;
                }
            }
        }
        return index >= n ? true : false;
    }
}
// @lc code=end
