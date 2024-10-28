package com.company;

import java.util.Stack;

/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 **/
public class Solution_括号序列 {

    /**
     * 思路：逐个遍历字符串，遇到'(','{','['就压入栈，
     * 遇到')','}',']'则弹出栈顶字符，判断是否合法，
     * 最后检查栈是否为空，为空则是合法括号序列。
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null)
            return true;
        if (s.length() % 2 == 1)
            return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (!stack.empty()) {
                if (s.charAt(i) == ')' && stack.pop() != '(')
                    return false;
                if (s.charAt(i) == '}' && stack.pop() != '{')
                    return false;
                if (s.charAt(i) == ']' && stack.pop() != '[')
                    return false;
            }else {
                return false;
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

}
