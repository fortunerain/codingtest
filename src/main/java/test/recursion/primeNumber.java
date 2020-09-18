package test.recursion;

import java.util.ArrayList;
import java.util.List;

public class primeNumber {
  public static void main(String[] args) {
    String s = "172";
    List<String> prime = new ArrayList<>();
    List<String> arr = new ArrayList<>();
    arr.add("1");
    arr.add("7");
    arr.add("2");

    List<String> result = new ArrayList<>();
    for (int i = 0; i < arr.size(); i++) {
      reculsion(arr, result, arr.size(), i + 1);
    }
//    System.out.println(prime);
  }

  /**
   * 순열 구하기
   *
   * @param arr    : 기준 리스트
   * @param result : 결과를 담아줄 리스트
   * @param n      : 전체 갯수
   * @param r      : 뽑을 갯수
   */
  private static void reculsion(List<String> arr, List<String> result, int n, int r) {

    if (r == 0) {


      System.out.println(result.toString());
      return;
    }

    for (int i = 0; i < n; i++) {

      result.add(arr.remove(i));
      reculsion(arr, result, n - 1, r - 1);
      arr.add(i, result.remove(result.size() - 1));
    }
  }

}
