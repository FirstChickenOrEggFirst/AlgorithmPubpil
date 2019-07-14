package com.itpubpil.datastructure.statck;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author wangjingbiao
 * createTime: 2019/7/14 14:47
 * desc: 栈的应用，括号匹配,leecode上的一道题目
 */
public class BracketMatching {

    private boolean isValid(String s) {
        Stack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();

                if (c == ')' && topChar != '(') {
                    return false;
                }

                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testMatch() {
        String s1 = "(()){}[]{}";
        Assert.assertTrue(isValid(s1));
        String s2 = "}()){}[]{}";
        Assert.assertFalse(isValid(s2));
        String s3 = "(()){}[]{}]";
        Assert.assertFalse(isValid(s3));
    }
}
