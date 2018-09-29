package com.roytrack.dailytest.leetcode;

import java.util.Stack;

/**
 * Created by roytrack on 2016-05-23.
 */
public class EvaluateReversePolishNotation150 {
  public static void main(String[] args) {
    String[] expression = {"2", "1", "+", "3", "*"};
    EvaluateReversePolishNotation150 e = new EvaluateReversePolishNotation150();
    System.out.println(e.evalRPN(expression));
    String[] expression2 = {"4", "13", "5", "/", "+"};
    System.out.println(e.evalRPN(expression2));
  }

  public int evalRPN(String[] tokens) {
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < tokens.length; i++) {
      if ("*/+-".contains(tokens[i])) {
        int a = Integer.valueOf(stack.pop());
        int b = Integer.valueOf(stack.pop());
        switch (tokens[i]) {
          case "*":
            a = b * a;
            break;
          case "/":
            a = b / a;
            break;
          case "+":
            a = b + a;
            break;
          case "-":
            a = b - a;
            break;
        }
        stack.push(String.valueOf(a));
      } else {
        stack.push(tokens[i]);
      }

    }
    int result = Integer.valueOf(stack.pop());
    return result;
  }
}
