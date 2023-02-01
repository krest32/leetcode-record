import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=692 lang=java
 *
 * [692] 前K个高频单词
 */

// @lc code=start
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 哈希排序
        // return extracted(words, k);

        // test
        return test(words, k);
    }

    private List<String> test(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.add(entry.getKey());
        }

        Collections.sort(ans, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return map.get(word1) == map.get(word2)
                        ? word1.compareTo(word2)
                        : map.get(word2) - map.get(word1);
            }
        });

        return ans.subList(0, k);
    }

    /**
     * 110/110 cases passed (6 ms)
     * Your runtime beats 78.39 % of java submissions
     * Your memory usage beats 78.02 % of java submissions (41.5 MB)
     * 
     * @param words
     * @param k
     * @return
     */
    private List<String> extracted(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        // 记录每个字符串出现的次数
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        // 将数据放入到 List 中进行排序-> 按照出现的次数，如果次数相同，就按照字典顺序排序
        List<String> rec = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            rec.add(entry.getKey());
        }
        Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return cnt.get(word1) == cnt.get(word2)
                        ? word1.compareTo(word2)
                        : cnt.get(word2) - cnt.get(word1);
            }
        });
        // 返回数据
        return rec.subList(0, k);
    }
}
// @lc code=end
