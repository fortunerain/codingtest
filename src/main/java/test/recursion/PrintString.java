package test.recursion;

import java.util.stream.Stream;

public class PrintString {
  public static void main(String[] args) {
    String s = "17";
    String[] arr = s.split("");
    int[] numbers = {1, 7};
    //    bruteForceCase(s);
    //    permutation(s);
    //    combine("abc", new StringBuffer(), 0);

    //    listPermutations(s);
    for (int i = 0; i <= s.length(); i++) {
      for (int j = i + 1; j <= s.length(); j++) {
        String substring = s.substring(i, j);
        permutation(substring);
      }
    }
  }

  private static void bruteForceCase(String s) {
    String[] split = s.split("");
    for (int i = 0; i < split.length; i++) {
      System.out.println(split[i]);
      for (int j = i + 1; j < split.length; j++) {
        System.out.println(split[i] + split[j]);
      }
    }
  }

  public static void permutation(String str) {
    permutation("", str);
  }

  private static void permutation(String prefix, String str) {
    int n = str.length();
    if (n == 0) {
      System.out.println(prefix);
    } else {
      for (int i = 0; i < n; i++) {
        permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
      }
    }
  }

  private static void combine(String instr, StringBuffer outstr, int index) {
    for (int i = index; i < instr.length(); i++) {
      outstr.append(instr.charAt(i));
      System.out.println(outstr);
      combine(instr, outstr, i + 1);
      outstr.deleteCharAt(outstr.length() - 1);
    }
  }

  private static void fibonacciJava8() {
    // iterate 로 초기 배열 (0, 1) 을 생성.
    // 두번째 인자는 UnaryOperator 인데, Function 인터페이스의 확장 형태로 T -> T 로 반환함.
    // 사이즈가 2인 배열을 (t[1], t[0] + t[1]) 형태로 입력된 초기값을 시작으로 t 에 결과를 계속 대입.
    Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
        .limit(20)
        .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
  }

  //abc
  //abc
  //abc
  //acb
  //bac
  //bac
  //bca
  //cab
  //cab
  //cba
  static void permutationsWithPrefix(String thePrefix, String theString) {
    if (theString.length() != 0) {
      System.out.println(thePrefix + theString);
    }
    for (int i = 0; i < theString.length(); i++) {
      char c = theString.charAt(i);
      String workingOn = theString.substring(0, i) + theString.substring(i + 1);
      permutationsWithPrefix(thePrefix + c, workingOn);
    }
  }

  static void listPermutations(String theString) {
    permutationsWithPrefix("", theString);
  }

}
