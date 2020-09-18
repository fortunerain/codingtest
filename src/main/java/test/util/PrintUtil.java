package test.util;

import java.util.Queue;

public class PrintUtil {
  public static <T> void printArray(T[] arr) {
    for (T data : arr) {
      System.out.print(data + " ");
    }
    System.out.println();
  }

  public static void printArray(int[] arr) {
    for (int data : arr) {
      System.out.print(data + " ");
    }
    System.out.println();
  }

  public static void printArray(int[][] arr) {
    for (int[] rows : arr) {
      for (int data : rows) {
        System.out.print(data + " ");
      }
      System.out.println();
    }
  }

  public static <T> void printQueue(Queue<T> queue) {
    while (!queue.isEmpty()) {
      System.out.print(queue.poll() + " -> ");
    }
    System.out.println();
  }

  public static <T> void printQueueArray(Queue<T[]> queue) {
    while (!queue.isEmpty()) {
      T[] poll = queue.poll();
      System.out.print(poll[0] + "(" + poll[1] + ")" + " -> ");
    }
    System.out.println();
  }
}
