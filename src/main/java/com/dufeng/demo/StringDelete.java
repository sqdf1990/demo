package com.dufeng.demo;

import java.util.Stack;

/**
 * @description:
 * @author: dufeng
 * @create: 2018-11-15 19:45
 */
public class StringDelete {

    private static final String targetStr = "mi";

    public static String delete(String str) {

        if (str == null || str.length() < targetStr.length()) {
            return str;
        }

        Stack<Character> stack = new Stack<Character>();

        for (char c : str.toCharArray()) {
            if (c == 'i' && !stack.isEmpty() && stack.peek() == 'm') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(delete("ammimmiib"));
        System.out.println(delete("ammimiib"));
    }
}
