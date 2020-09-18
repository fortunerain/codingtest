package com.exam.test.arraystring;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static com.exam.test.util.PrintUtil.printArray;

public class SetToArray {
  public static void main(String[] args) {

    Set<Integer> set = new HashSet<>();
    set.add(3);
    set.add(2);
    set.add(1);
    set.add(4);
    int[] arr = new int[set.size()];
    Iterator iterator = set.iterator();

    int i = 0;
    while (iterator.hasNext()) {
      arr[i] = (int) iterator.next();
      i++;
    }

    printArray(arr);
  }
}
