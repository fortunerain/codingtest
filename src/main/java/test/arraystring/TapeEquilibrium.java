package test.arraystring;

import java.util.Arrays;

import static com.exam.test.util.PrintUtil.printArray;

public class TapeEquilibrium {
  public static void main(String[] args) {
    int[] A = {3, 1, 2, 4, 3};
    int[] result = new int[A.length - 1];
    int[] dist = new int[A.length - 1];
    int total = 0;
    for (int i = 0; i < A.length; i++) {
      total += A[i];
      if (i < A.length - 1) {
        dist[i] = total;
      }
    }

    System.out.println(total);
    printArray(dist);
    for (int i = 0; i < dist.length; i++) {
      int diff = Math.abs(dist[i] - (total - dist[i]));
      result[i] = diff;
    }

    Arrays.sort(result);
    System.out.println(result[0]);

  }
}
