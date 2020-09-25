package com.exam.test.arraystring;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class NbinaryTest {

  @Test
  public void BinaryTest() {
    Stack stack = new Stack();
    int a = 65;
    char c = new Character((char) a);
    stack.push(c);


    String   pop = String.valueOf(stack.pop());
    System.out.println(pop);
  }

}