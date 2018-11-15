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
        //用来存放过滤后的字符的栈
        Stack<Character> stack = new Stack<Character>();
        //如果有n个"mi"，这个循环会执行2n+常数个非m、i字符个数步骤，即时间复杂度为O(2n)
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
        //输出amb
        System.out.println(delete("ammimmiib"));
        //输出ab
        System.out.println(delete("ammimiib"));
        //输出abmm
        System.out.println(delete("ammimiibmimm"));
    }
}
