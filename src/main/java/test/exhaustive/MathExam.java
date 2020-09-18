package test.exhaustive;

import com.exam.test.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;


public class MathExam {
  public static void main(String[] args) {
    int[] answers = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
//    int[] answers = {1,3,2,4,2};
    int[] pattern1 = {1, 2, 3, 4, 5};
    int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    int count1 = 0, count2 = 0, count3 = 0;
    for (int i = 0; i < answers.length; i++) {
      for (int j = i; j < answers.length; j++) {
        if (answers[i] == pattern1[j % 5]) {
          count1++;
        }

        if (answers[i] == pattern2[j % 8]) {
          count2++;
        }

        if (answers[i] == pattern3[j % 10]) {
          count3++;
        }

        break;
      }
    }

    // max 값 구하기
    int[] counts = new int[]{count1, count2, count3};
    // Arrays.sort 로 정렬을 해버리면 원본 순서가 바뀌므로 찾고자 하는 index 값을 찾을수 없다.
//    Arrays.sort(counts);
//    int max = Arrays.stream(counts).max().getAsInt();

    // stream 사용하는거 보다 훨씬 빠름 1초 이내.
    int max = Math.max(counts[0], Math.max(counts[1], counts[2]));

    // 결과값을 필요한 만큼만 담기
    List<Integer> array = new ArrayList<>();
    for (int i = 0; i < counts.length; i++) {
      if (max == counts[i]) {
        array.add(i + 1);
      }
    }

    // 다시 배열로 변환.
//    int[] result = array.stream().mapToInt(i -> i).toArray();

    // stream 사용하는거 보다 훨씬 빠름 1초 이내.
    int[] result = new int[array.size()];
    for (int i = 0; i < array.size(); i++) {
      result[i] = array.get(i);
    }

    PrintUtil.printArray(result);
  }
}
