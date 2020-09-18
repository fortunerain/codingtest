package test.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiskController {
  public static void main(String[] args) {
    //    int[][] jobs = {{0, 3}, {4, 3}, {1, 9}, {20, 1}};
    int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
    int answer = 0;

    Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

    // PriorityQueue 라서 우선순위 때문에 순서가 바뀌므로 int[] 을 가져가서 이용한다.
    Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

    int total = 0;
    int endpoint = 0;
    int idx = 0;
    int count = 0;

    while (count < jobs.length) {

      while (idx < jobs.length && jobs[idx][0] <= endpoint) {
        queue.offer(jobs[idx++]);
      }
      if (queue.isEmpty()) {
        endpoint = jobs[idx][0];
      } else {
        // queue.poll() 을 하고 뒤에 peek을 하면 다음 노드의 값이 peek 된다. 조심해야함.
        int[] data = queue.poll();
        int key = data[1];

        int takenTime = key + endpoint - data[0];
        endpoint += key;
        total += takenTime;
        count++;
      }

    }

    answer = (int) Math.floor(total / jobs.length);
    System.out.println(answer);

  }
}
