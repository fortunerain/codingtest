package test.stackqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BridgeTruck {
  public static void main(String[] args) {
    int bridge_length = 2;
    int weight = 10;
    int[] truck_weights = {7, 4, 5, 6};

    int sec = 0;
    LinkedList<int[]> queue = new LinkedList<>();
    List<Integer> result = new ArrayList<>(truck_weights.length);
    int curr_weight = 0;
    int index = 0;
    int truckIdx = 0;
    while (result.size() < truck_weights.length) {

      // 다리 위에 트럭이 있으면 삭제
      for (int j = 0; j < queue.size(); ) {
        if (--queue.get(j)[1] == 0) {
          curr_weight -= queue.get(j)[0];
          queue.remove(j);
        } else {
          j++;
        }
      }

      // 다리에 올라올수 있는 무게 제한 조건
      if (index < truck_weights.length && curr_weight + truck_weights[index] <= weight) {
        queue.add(new int[] {truck_weights[index], bridge_length});
        curr_weight += truck_weights[index];
        index++;
      }

      sec++;
      // 다리에 트럭이 더이상 없으면 종료
      if (queue.size() == 0) {
        break;
      }

    }

    System.out.println(sec);
  }
}
