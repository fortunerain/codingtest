package test.arraystring;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    test("abc");
  }

  static String[] test(String s) {
    int len = s.length();
    String str = "";

    List<String> array = new ArrayList<String>();

    for (int i = 0; i < len; i++) {
      for (int j = 1; j <= len - i; j++) {
        str = s.substring(i, i + j);
        array.add(str);
        System.out.println(str);
      }
    }

    String[] result = new String[array.size()];
    int k = 0;
    for (String temp : array) {
      result[k++] = temp;
      //        	System.out.println(temp);
    }

    return result;
  }

}
