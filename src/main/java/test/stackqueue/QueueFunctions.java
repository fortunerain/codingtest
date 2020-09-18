package test.stackqueue;

import com.exam.test.util.PrintUtil;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static com.exam.test.util.PrintUtil.printQueueArray;

public class QueueFunctions {
  public static void main(String[] args) {
    String[] arr = {"a", "c", "b", "a", "b"};
    String[][] arr2 = {{"b", "3"}, {"c", "2"}, {"e", "1"}, {"a", "3"}, {"d", "1"}};

    makePriorityQueue(arr);
    makePriorityQueueReverse(arr);

    makePriorityQueueReverseBySecondValue(arr2);
  }

  private static void makePriorityQueue(String[] arr) {
    // 우선순위 큐는 기본 오름차순 정렬됨
    Queue<String> queue = new PriorityQueue<>(arr.length);
    for (String str : arr) {
      queue.offer(str);
    }

    PrintUtil.printQueue(queue);
  }

  private static void makePriorityQueueReverse(String[] arr) {
    // 우선순위 큐는 기본 오름차순 정렬됨
    Queue<String> queue = new PriorityQueue<>((a, b) -> b.compareTo(a));
    for (String str : arr) {
      queue.offer(str);
    }

    Queue<String> queue2 = new PriorityQueue<>(Comparator.reverseOrder());
    for (String str : arr) {
      queue2.offer(str);
    }

    PrintUtil.printQueue(queue);
    PrintUtil.printQueue(queue2);
  }

  private static void makePriorityQueueReverseBySecondValue(String[][] arr) {
    // 큐 이므로 배열의 입력 순서대로 출력되지만
    // 이차원 배열의 두번째 값을 기준으로 역정렬을 했기 때문에 우선순위가 높으면서 배열 입력순으로 나옴.
    Queue<String[]> queue = new PriorityQueue<>((a, b) -> b[1].compareTo(a[1]));
    for (int i = 0; i < arr.length; i++) {
      queue.offer(arr[i]);
    }

    printQueueArray(queue);

    Queue<String[]> queue2 = new PriorityQueue<>((a, b) -> {
      // value가 같으면 key 순 정렬, 아니면 value 로 역정렬
      if (a[1].equals(b[1])) {
        return a[0].compareTo(b[0]);
      } else {
        return b[1].compareTo(a[1]);
      }
    });
    for (int i = 0; i < arr.length; i++) {
      queue2.offer(arr[i]);
    }

    printQueueArray(queue2);

  }

}
