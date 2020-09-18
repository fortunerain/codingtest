package test.stackqueue;

import com.exam.test.util.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class FunctionProcess {
  public static void main(String[] args) {
    int[] progresses = {93, 30, 55};
    int[] speeds = {1, 30, 5};
    //    int[] progresses = {95, 90, 99, 99, 80, 99};
    //    int[] speeds = {1, 1, 1, 1, 1, 1};

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < progresses.length; i++) {
      int takeNum = (100 - progresses[i]) / speeds[i];
      int left = (100 - progresses[i]) % speeds[i];
      if (left > 0) {
        takeNum++;
      }
      //      System.out.print(takeNum + ",");
      queue.add(takeNum);

    }
    System.out.println();

    int[] calculate = calculate(queue, progresses.length);
    PrintUtil.printArray(calculate);

  }

  private static int[] calculate(Queue<Integer> queue, int n) {
    int temp = 0, count = 1, index = 0;
    List<Integer> result = new ArrayList<>();
    while (index <= n) {
      if (queue.isEmpty()) {
        result.add(count);
        break;
      }
      int takeNum = queue.remove();
      if (temp < takeNum) {
        temp = takeNum;
        // 두번째 데이터 부터 첫번째와의 비교가 가능하므로 첫번째꺼는 거른다.
        if (index > 0) {
          result.add(count);
        }
        count = 1;
      } else {
        count++;
      }
      index++;
    }

    int[] deploys = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      deploys[i] = result.get(i);
    }

    return deploys;
  }
}
