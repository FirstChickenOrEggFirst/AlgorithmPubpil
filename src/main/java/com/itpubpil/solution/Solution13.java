package com.itpubpil.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangjingbiao
 * createDate: 2021/11/15 周一 4:00 下午
 * desc:
 */
public class Solution13 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("I"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));
    }

    private static class Solution {
        private static final Map<Character, Integer> numMap = new HashMap<>();

        static {
            numMap.put('I', 1);
            numMap.put('V', 5);
            numMap.put('X', 10);
            numMap.put('L', 50);
            numMap.put('C', 100);
            numMap.put('D', 500);
            numMap.put('M', 1000);
        }

        public int romanToInt(String s) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                char romanChar = s.charAt(i);
                int num = numMap.get(romanChar);
                if (i != s.length() - 1) {
                    char nextRomanChar = s.charAt(i + 1);
                    boolean isSpecialI = (romanChar == 'I' && (nextRomanChar == 'X' || nextRomanChar == 'V'));
                    boolean isSpecialX = (romanChar == 'X' && (nextRomanChar == 'L' || nextRomanChar == 'C'));
                    boolean isSpecialC = (romanChar == 'C' && (nextRomanChar == 'D' || nextRomanChar == 'M'));
                    if (isSpecialI || isSpecialX || isSpecialC) {
                        num = -num;
                    }
                }
                result += num;
            }
            return result;
        }
    }

    // 解法2。更简单，不用判断特殊字符，只要后一位比前一位大即代表需要做减法，否则做加法
    private static class Solution2 {
        private static final Map<Character, Integer> numMap = new HashMap<>();

        static {
            numMap.put('I', 1);
            numMap.put('V', 5);
            numMap.put('X', 10);
            numMap.put('L', 50);
            numMap.put('C', 100);
            numMap.put('D', 500);
            numMap.put('M', 1000);
        }

        public int romanToInt(String s) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                char romanChar = s.charAt(i);
                int num = numMap.get(romanChar);
                if (i != s.length() - 1) {
                    char nextRomanChar = s.charAt(i + 1);
                    boolean isSpecialI = (romanChar == 'I' && (nextRomanChar == 'X' || nextRomanChar == 'V'));
                    boolean isSpecialX = (romanChar == 'X' && (nextRomanChar == 'L' || nextRomanChar == 'C'));
                    boolean isSpecialC = (romanChar == 'C' && (nextRomanChar == 'D' || nextRomanChar == 'M'));
                    if (isSpecialI || isSpecialX || isSpecialC) {
                        num = -num;
                    }
                }
                result += num;
            }
            return result;
        }
    }

}
