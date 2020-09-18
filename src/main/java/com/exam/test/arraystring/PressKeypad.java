package com.exam.test.arraystring;

public class PressKeypad {
  public static void main(String[] args) {
    int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
    String hand = "right";
    StringBuilder builder = new StringBuilder();
    int left = 10, right = 12;
    for (int i = 0; i < numbers.length; i++) {

      int val = numbers[i];
      if (val == 1 || val == 4 || val == 7) {
        builder.append("L");
        left = val;
      } else if (val == 3 || val == 6 || val == 9) {
        builder.append("R");
        right = val;
      } else {
        // 2, 5, 8, 0
        // 세로로 위치해 있을 경우 빼면 3이 나온다. 실제 거리 차이는 1이다.
        // 0일때 조심해야 겠다. 8-0 은 8 로 나옴. 1로 계산해야 한다.

        int leftVal = getDist(val, left);
        int rightVal = getDist(val, right);
        if (leftVal > rightVal) {
          builder.append("R");
          right = val;
        } else if (leftVal < rightVal) {
          builder.append("L");
          left = val;
        } else {
          if ("right".equals(hand)) {
            builder.append("R");
            right = val;
          } else {
            builder.append("L");
            left = val;
          }
        }
      }
    }

    System.out.println(builder.toString());
  }

  private static int getDist(int val, int location) {
    if (location == 0) {
      location = 11;
    }
    if (val == 0) {
      val = 11;
    }

    int distX = (location - 1) / 3;
    int distY = (location - 1) % 3;
    int valX = (val - 1) / 3;
    int valY = (val - 1) % 3;

    return Math.abs(distX - valX) + Math.abs(distY - valY);
  }


}
