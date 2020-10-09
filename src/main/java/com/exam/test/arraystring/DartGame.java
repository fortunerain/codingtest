package com.exam.test.arraystring;

import java.util.Arrays;

enum Bonus {
  S(1),
  D(2),
  T(3);

  int times;

  Bonus(int times) {
    this.times = times;
  }

  public static Bonus find(String bonusName) {
    return Arrays.stream(Bonus.values())
      .filter(bonus -> bonus.name().equals(bonusName))
      .findAny()
      .orElse(null);
  }
}


public class DartGame {
  public static void main(String[] args) {
//    String dartResult = "1S2D*3T";  // 37
//    String dartResult = "1D2S#10S"; // 9
//    String dartResult = "1D2S0T"; // 3
//    String dartResult = "1S*2T*3S"; // 23
//    String dartResult = "1D#2S*3S"; // 5
//    String dartResult = "1T2D3D#"; // -4
    String dartResult = "1D2S3T*"; // 59

    int[] result = new int[3];
    String[] split = customSplit(dartResult);
    for (int i = 0; i < split.length; i++) {
      result[i] = getScore(split[i]);
      setOption(result, split, i);
    }

    int sum = getSum(result);
    System.out.println(sum);

  }

  private static void setOption(int[] result, String[] split, int i) {
    if (i == 0 && split[i].contains("*")) {
      result[i] *= 2;
    } else if (i != 0 && split[i].contains("*")) {
      result[i - 1] *= 2;
      result[i] *= 2;
    } else if (split[i].contains("#")) {
      result[i] *= -1;
    } else if (split[i].contains("*") && split[i].contains("#")) {
      result[i] *= -2;
    }
  }

  private static int getSum(int[] result) {
    int sum = 0;
    for (int i = 0; i < result.length; i++) {
      sum += result[i];
    }
    return sum;
  }

  private static String[] customSplit(String dartResult) {
    String[] temp = new String[3];
    int j = 0, index = 0;
    for (int i = 0; i < dartResult.length(); i++) {
      char c = dartResult.charAt(i);
      if (!Character.isDigit(c)) {
        int endIndex = i + 1;
        if (endIndex < dartResult.length() && (dartResult.charAt(endIndex) == '*' || dartResult.charAt(endIndex) == '#')) {
          endIndex++;
          i++;
        }
        temp[index] = dartResult.substring(j, endIndex);
        j = endIndex;
        index++;
      }
    }
    return temp;
  }

  private static int getScore(String dartResult) {

    double score = 0;
    for (int i = 0; i < dartResult.length(); i++) {
      char c = dartResult.charAt(i);

      // 숫자일 경우 밑이 된다.
      if (Character.isDigit(c)) {
        score = c - '0';
        char next = dartResult.charAt(i + 1);
        if (Character.isDigit(next)) {
          score = score * 10 + (next - '0');
          i++;
          continue;
        }

        continue;
      }

      // 몇번 곱할지(지수)
      Bonus bonus = Bonus.find(String.valueOf(c));
      double pow = Math.pow(score, bonus.times);
      return (int) pow;
    }
    return 0;
  }
}