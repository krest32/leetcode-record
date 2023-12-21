import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=648 lang=java
 *
 * [648] 单词替换
 */

// @lc code=start
class Solution {
    public String replaceWords(List<String> roots, String sentence) {
        // 模拟
        // return extracted(roots, sentence);

        return test(roots, sentence);
    }

    private String test(List<String> roots, String sentence) {
        Set<String> rootSet = new HashSet<>();
        for (String root : roots) {
            rootSet.add(root);
        }

        StringBuilder ans = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (rootSet.contains(prefix)) {
                    break;
                }
            }
            if (ans.length() > 0) {
                ans.append(" ");
            }
            ans.append(prefix);
        }
        return ans.toString();
    }

    /**
     * 127/127 cases passed (858 ms)
     * Your runtime beats 5.11 % of java submissions
     * Your memory usage beats 15.03 % of java submissions (54.2 MB)
     * 
     * @param roots
     * @param sentence
     * @return
     */

    private String extracted(List<String> roots, String sentence) {
        Set<String> rootSet = new HashSet<>();
        for (String root : roots) {
            rootSet.add(root);
        }

        StringBuilder ans = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (rootSet.contains(prefix)) {
                    break;
                }
            }
            if (ans.length() > 0) {
                ans.append(" ");
            }
            ans.append(prefix);
        }
        return ans.toString();
    }
}
// @lc code=end
