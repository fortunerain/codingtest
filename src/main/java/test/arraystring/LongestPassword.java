package test.arraystring;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LongestPassword {
  public static void main(String[] args) {
//    String S = "test1 5 a0A passa0071 ?xy1";
    String S = "abc00 ab000 abc000 aded00";
    String[] arr = S.split(" ");
    int password = isPassword(arr);
    System.out.println(password);

  }

  private static int isPassword(String[] arr) {
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      String string = arr[i];
      if (!isReg(string)) {
        continue;
      }

      // 문자열 길이가 짝수이면 skip
      int length = string.length();
      if (length % 2 == 0) {
        continue;
      }
      int count = 0;
      // 문자 세기
      for (int j = 0; j < length; j++) {
        if (isCharacter(string.charAt(j))) {
          count++;
        }
      }

      // 홀수개의 문자면 skip
      if (count % 2 != 0) {
        continue;
      }

      System.out.println(string);
      list.add(length);
    }

    list.sort(Comparator.reverseOrder());
    if (list.size() == 0) {
      return -1;
    }
    return list.get(0);
  }

  public static boolean isReg(String s) {
    boolean matches = s.matches("^[0-9a-zA-Z]+$");
    return matches;
  }

  public static boolean isCharacter(char c) {
    return !Character.isDigit(c);
  }

}
