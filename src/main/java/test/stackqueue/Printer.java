package test.stackqueue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer {
  public static void main(String[] args) {
//    int[] priorities = {1, 1, 9, 1, 1, 1};  //1
    int[] priorities = {2, 1, 3, 2};  //5
    int location = 2;

    // maxheap 에 다 넣자.
    // 아래와 같이 하면 내림차순으로 정렬하기 때문에 기존 배열의 값의 순서가 달라져서 다른 케이스에서는 안된다.
    // 처음 꺼낸 값 보다 큰값이 있으면 맨뒤로 보낸다.
    // 일반 큐에 담자.

    // 최대값만 구하기
    Queue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a);
    for (int i = 0; i < priorities.length; i++) {
      maxheap.offer(priorities[i]);
    }

    int max = maxheap.poll();

    // 일반 큐에 복사
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < priorities.length; i++) {
      queue.offer(new int[] {priorities[i], i});
    }

    int count = 0;
    while (!queue.isEmpty()) {
      int[] data = queue.peek();
      if (data[0] == max) {
        if (data[1] == location) {
          queue.poll();
          // 맨처음 바로 찾았을때
//          if (count != 0) {
            count++;
//          }
          System.out.println(count);
          break;
        }
        queue.poll();
        count++;
        max = maxheap.poll();

      } else if (data[0] < max) {
        queue.poll();
        queue.add(data);
      }
    }


    while (!queue.isEmpty()) {
      int[] data = queue.poll();
      System.out.println(data[0] + "," + data[1]);
    }

    /*Queue<int[]> maxheap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

    for (int i = 0; i < priorities.length; i++) {
      maxheap.offer(new int[] {priorities[i], i});
    }

    int count = 1;
    while (!maxheap.isEmpty()) {
      int[] arr = maxheap.poll();
      if (arr[1] == location) {
        System.out.println(count);
      }
      count++;
    }*/

  }
}
