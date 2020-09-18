package com.exam.test.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import static com.exam.test.util.PrintUtil.printArray;

public class Scoville {
  public static void main(String[] args) {
    // 우선순위 큐를 알아야 함.
    // heap 트리를 이용.
    // 재귀 이용.
    int[] arr = {1, 2, 3, 9, 10, 12};
    int k = 7;

    // 누적된 값을 반환 해야함.
    int count = rotation(arr, k, 0);
    int count2 = priorityQueue(arr, k);
    System.out.println(count);
    System.out.println(count2);

  }

  private static int rotation(int[] arr, int k, int count) {
    if (arr.length == 0) {
      if (arr[0] >= k) {
        return count;
      }
      return -1;
    }

    Arrays.sort(arr);
    int first = arr[0];

    // 섞음.
    if (first < k) {
      int second = arr[1];
      int scoville = first + (second * 2);
      // 새로운 배열 만들어서 재귀
      int[] newArr = new int[arr.length - 1];
      newArr[0] = scoville;
      // 나머지 값 복사.
      for (int i = 1; i < arr.length - 1; i++) {
        newArr[i] = arr[i + 1];
      }
      printArray(newArr);
      return rotation(newArr, k, count + 1);
    }

    return count;
  }

  private static int priorityQueue(int[] arr, int k) {
    Queue<Integer> heap = new PriorityQueue<>(arr.length);
    // 큐에 모두 삽입
    for (int i : arr) {
      heap.offer(i);
    }

    int count = 0;
    while (heap.peek() < k) {
      // 1개만 남으면 scoville 계산을 못하니까 끝임.
      if (heap.size() == 1) {
        return -1;
      }
      int scoville = heap.poll() + (heap.poll() * 2);
      // 큐의 마지막에 값을 넣어줘도 우선순위 큐이기 때문에 낮은 숫자 먼저 poll 된다.
      heap.offer(scoville);
      System.out.println("heap : " + heap);
      count++;
    }

    int ceil = (int) Math.ceil(k - (heap.size() - 1) / heap.size());
    return count;
  }
}
