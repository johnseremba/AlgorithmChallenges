package com.serions.codility;

import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
        System.out.println(checkBrackets("{[()()]}"));
    }

    private static int checkBrackets(String S) {
        // special case
        if (S.length() == 0) return 1;

        Stack<Character> stack = new Stack<>();

        // scan the string
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') stack.push(')');
            else if (S.charAt(i) == '[') stack.push(']');
            else if (S.charAt(i) == '{') stack.push('}');
            else if (S.charAt(i) == ')' || S.charAt(i) == ']' || S.charAt(i) == '}') {
                if (stack.isEmpty()) return 0;
                else {
                    char temp = stack.pop();
                    if(temp != S.charAt(i)) return 0;
                }
            }
        }
        if (stack.isEmpty()) return 1;
        else return 0;
    }
}
