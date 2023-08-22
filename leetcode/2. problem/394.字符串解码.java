import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    String src;
    int ptr;

    public String decodeString(String s) {
        // 1. 递归
        // return extracted(s);

        // 2. 栈操作
        // return extracted2(s);

    }

    /**
     * Your runtime beats 100 % of java submissions
     * Your memory usage beats 83.21 % of java submissions (39.1 MB)
     * 
     * @param s
     * @return
     */
    private String extracted(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    // 递归解码
    public String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']')
            return "";
        char cur = src.charAt(ptr);
        StringBuilder ret = new StringBuilder();
        if (Character.isDigit(cur)) {
            int repTime = getDigits();
            // 过滤左括号
            ptr++;
            // 解析 String
            String str = getString();
            // 过滤右括号
            ptr++;
            // 构造字符串
            while (repTime-- > 0)
                ret.append(str);
        } else if (Character.isLetter(cur))
            ret.append(src.charAt(ptr++));
        return ret.append(getString()).toString();
    }

    public int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr)))
            ret = ret * 10 + src.charAt(ptr++) - '0';
        return ret;
    }

    private String extracted2(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits2(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString2(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString2(stk);

    }

    public String getDigits2(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString2(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}
// @lc code=end
