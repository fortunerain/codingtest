package com.exam.test.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
  public static void main(String[] args) {
    String[] phone_book = {"119", "97674223", "1195524421"};
    //    String[] phone_book = {"123", "456", "789"};
    System.out.println(phoneBook(phone_book));
  }

  private static boolean phoneBook(String[] phone_book) {
    Arrays.sort(phone_book);
    boolean answer = true;
    Map<Integer, String> map = new HashMap<>();
    for (int i = 0; i < phone_book.length; i++) {
      map.put(i, phone_book[i]);
    }
    for (int i = 0; i < phone_book.length; i++) {
      for (int j = 0; j < phone_book.length; j++) {
        if (map.get(i).equals(phone_book[j])) {
          continue;
        } else if (map.get(i).startsWith(phone_book[j])) {
          answer = false;
          break;
        }

      }
    }
    return answer;
  }
}
