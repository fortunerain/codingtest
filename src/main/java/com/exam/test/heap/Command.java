package com.exam.test.heap;

import com.exam.test.util.PrintUtil;

import java.util.*;


public class Command {
  public static void main(String[] args) {
//    String[] operations = {"I 16","D 1"};
    String[] operations = {"I 7", "I 5", "I -5", "D -1"};
//    String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
    int[] answer = new int[2];
    Queue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < operations.length; i++) {
      String command = operations[i];
      String[] split = command.split(" ");
      if ("I".equals(split[0])) {
        // 삽입
        offerQueue(Integer.parseInt(split[1]), minHeap, maxHeap);
      } else if (!maxHeap.isEmpty()) {
        // 최대값 삭제
        if ("1".equals(split[1])) {
          removeQueue(minHeap, maxHeap.poll());
        } else {
          removeQueue(maxHeap, minHeap.poll());
        }
      }
    }
    answer[0] = maxHeap.isEmpty() ? 0 : maxHeap.poll();
    answer[1] = minHeap.isEmpty() ? 0 : minHeap.poll();
    PrintUtil.printArray(answer);
//    return answer;
  }

  private static void offerQueue(int number, Queue<Integer> minHeap, Queue<Integer> maxHeap) {
    minHeap.offer(number);
    maxHeap.offer(number);
  }

  private static void removeQueue(Queue<Integer> queue, int num) {
    // 삭제 후 minHeap 을 돌면서 temp 에 값을 저장한다. 삭제 되었던 최대값을 발견하면 temp 값이 최대값 결과 이므로
    List<Integer> tmp = new ArrayList<>();
    while (!queue.isEmpty()) {
      int poll = queue.poll();
      if (num == poll) break;
      tmp.add(poll);
    }
    queue.addAll(tmp);
  }
}
