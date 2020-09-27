package com.exam.test.arraystring;

import java.util.Arrays;

public class ValidAnagram {
  public static void main(String[] args) {
    String s = "ab", t = "a";
//    String s = "anagram", t = "nagaram";

    boolean anagram = isAnagram(s, t);
    System.out.println(anagram);

    boolean anagram2 = isAnagram2(s, t);
    System.out.println(anagram2);
  }

  private static boolean isAnagram(String s, String t) {
    int[] alphabet = new int[26];
    for (int i = 0; i < s.length(); i++) {
      // 아래와 같이 배열의 인덱스가 된다.
      // char a - 'a' = 65 - 65 = 0
      // char b - 'a' = 66 - 65 = 1
      alphabet[s.charAt(i) - 'a']++;
    }

    for (int j = 0; j < t.length(); j++) {
      alphabet[t.charAt(j) - 'a']--;
    }

    for (int i : alphabet) if (i != 0) return false;
    return true;
  }

  private static boolean isAnagram2(String s, String t) {
    char[] chararray1 = new char[s.length()];
    char[] chararray2 = new char[t.length()];

    for(int i = 0 ; i < s.length() ;i++){
      chararray1[i] = s.charAt(i);
    }

    for(int i = 0 ; i < t.length() ;i++){
      chararray2[i] = t.charAt(i);
    }

    Arrays.sort(chararray1);
    Arrays.sort(chararray2);

    if(Arrays.equals(chararray1, chararray2)){
      return true;
    }else{
      return false;
    }
  }
}
