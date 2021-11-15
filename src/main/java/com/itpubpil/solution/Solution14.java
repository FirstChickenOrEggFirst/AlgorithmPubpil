package com.itpubpil.solution;

/**
 * @author wangjingbiao
 * createDate: 2021/11/15 周一 3:23 下午
 * desc: 14号问题，最长公共前缀
 */
public class Solution14 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flag"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"apple", "banana", "orange"}));

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.longestCommonPrefix(new String[]{"flower", "flow", "flag"}));
        System.out.println(solution2.longestCommonPrefix(new String[]{"apple", "banana", "orange"}));
    }

    private static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }

            if (strs.length == 1) {
                return strs[0];
            }
            StringBuilder resultBuilder = new StringBuilder();
            for (int i = 0; i < strs[0].length(); i++) {
                String commonStart = resultBuilder.toString() + strs[0].charAt(i);
                boolean isEnd = false;
                for (int j = 1; j < strs.length; j++) {
                    if (!strs[j].startsWith(commonStart)) {
                        isEnd = true;
                        break;
                    }
                }

                if (isEnd) {
                    break;
                } else {
                    resultBuilder.append(strs[0].charAt(i));
                }
            }
            return resultBuilder.toString();
        }
    }

    // 解法2
    private static class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0)
                return "";
            String res = strs[0];
            int i = 1;
            while (i < strs.length) {
                while (strs[i].indexOf(res) != 0) {//这是个循环不是if()，res更新后还要继续循环，直到=0
                    //strs[i].indexOf(res) = 0说明indexOf(res)在strs[i]中的索引为0，说明此时的res是这两个字符串的最长公共前缀
                    //strs[i].indexOf(res) != 0说明res在strs[i]中的索引不是0，要么不存在为-1，要么在>0的索引位置   这时候要一位一位地减少并更新res，直到为0或匹配      直接减少到为0时，代表着这两个字符串一点不匹配，这两个字符串的公共前缀为空，此时最长公共前缀也为空
                    res = res.substring(0, res.length() - 1);//更新res   res减1位继续参与循环
                }
                i++;
            }
            return res;
        }
    }

}
