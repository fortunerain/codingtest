package com.exam.test.stackqueue;

import java.util.Stack;

public class DeletePairString {
  public static void main(String[] args) {
    String s = "baabaa";
    // String 배열로 만든다.
    // 스택에서 꺼낸 값과 배열의 값을 비교해서 같으면 pop 하고 다르면 push 한다.

    String[] arr = s.split("");
    Stack<String> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (!stack.isEmpty() && stack.peek().equals(arr[i])) {
        stack.pop();
      } else {
        stack.push(arr[i]);
      }
    }

    int result = stack.isEmpty() ? 1 : 0;
    System.out.println(result);


  }

}
