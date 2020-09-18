package test.sort;

import com.exam.test.util.PrintUtil;

public class QuickSort {
  // O(nlogn) 의 시간복잡도. 최악의 경우 O(n^2)
  public static void main(String[] args) {
    int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
    PrintUtil.printArray(arr);
    quickSort(arr);
    PrintUtil.printArray(arr);
  }

  private static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  private static void quickSort(int[] arr, int start, int end) {
    int part2 = partition(arr, start, end);
    // 왼쪽 파티션
    if (start < part2 - 1) {
      quickSort(arr, start, part2 - 1);
    }
    // 오른쪽 파티션 part2 오른쪽 파티션의 시작값.
    if (part2 < end) {
      quickSort(arr, part2, end);
    }
  }

  private static int partition(int[] arr, int start, int end) {
    // 중간값을 피벗값으로 함.
    int pivot = arr[(start + end) / 2];
    // start, end 포인트가 서로 만날때까지 양쪽 포인터를 한칸씩 이동.
    while (start <= end) {
      // start 포인터의 값이 피벗 값보다 작으면 start 포인터는 앞으로 한칸 이동
      while (arr[start] < pivot) {
        start++;
      }
      // end 포인터의 값이 피벗 값보다 크면 end 포인터는 뒤로 한칸 이동
      while (arr[end] > pivot) {
        end--;
      }
      if (start <= end) {
        swap(arr, start, end);
        start++;
        end--;
      }
    }
    // 위의 while문을 계속 반복하게 되면 start 포인터에 새로 나눌 오른쪽 파티션의 첫번째 배열값이 들어감.
    return start;
  }

  private static void swap(int[] arr, int start, int end) {
    int tmp = arr[start];
    arr[start] = arr[end];
    arr[end] = tmp;
  }


}
