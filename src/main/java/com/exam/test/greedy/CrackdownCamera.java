package com.exam.test.greedy;

import java.util.Arrays;

public class CrackdownCamera {
  public static void main(String[] args) {

    int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
    Arrays.sort(routes, (a, b) -> a[1] - b[1]);

    int min = Integer.MIN_VALUE;
    int count = 0;
    for (int i = 0; i < routes.length; i++) {
      if (min < routes[i][0]) {
        min = routes[i][1];
        ++count;
      }
    }
    System.out.println(count);
  }
}
