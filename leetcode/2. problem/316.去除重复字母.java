/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        // 贪心
        // return extracted(s);

        // test
        return test(s);
    }

    private String test(String s) {
        boolean[] vis = new boolean[26];
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char tempCh = s.charAt(i);
            if (!vis[tempCh - 'a']) {
                while (res.length() > 0 && res.charAt(res.length() - 1) > tempCh) {
                    if (cnt[res.charAt(res.length() - 1) - 'a'] > 0) {
                        vis[res.charAt(res.length() - 1) - 'a'] = false;
                        res.deleteCharAt(res.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[tempCh - 'a'] = true;
                res.append(tempCh);
            }
            cnt[tempCh - 'a']--;
        }
        return res.toString();
    }

    /**
     * 290/290 cases passed (1 ms)
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 70.31 % of java submissions (40.4 MB)
     * 
     * @param s
     * @return
     */
    private String extracted(String s) {
        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        // 记录每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 判断当前字符是否被使用
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    // 如果如果当前字符的字典顺序更小，且之前追加的字符仍然有,
                    // 那么就去掉末尾的字符，重新拼接
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                // 标记当前字符被使用
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }
}
// @lc code=end
