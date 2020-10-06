package com.exam.test.greedy;

import java.util.Arrays;

public class Lifeboat {
  public static void main(String[] args) {
//    int[] people = {70, 50, 80, 50};
    int[] people = {40, 40, 40};
    int limit = 100;

    int result = solution(people, limit);
    System.out.println(result);

  }

  public static int solution(int[] people, int limit) {
    Arrays.sort(people);
    // min 값과 max 값을 더한게 최소한으로 옮기는 횟수이다.
    int count = 0;
    int min = 0;
    for (int max = people.length - 1; min <= max; max--) {
      if (people[min] + people[max] <= limit) {
        min++;
      }
      count++;
    }
    return count;
  }
}
