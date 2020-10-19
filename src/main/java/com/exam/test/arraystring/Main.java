package com.exam.test.arraystring;

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = reader.readLine();
    int a = Integer.parseInt(s);
    String s1 = reader.readLine();
    int b = Integer.parseInt(s1);
    String s2 = reader.readLine();
    int c = Integer.parseInt(s2);

    int multi = a * b * c;
    String result = String.valueOf(multi);
    String[] split = result.split("");
    for (int i = 0; i <= 9; i++) {
      int count = 0;
      for (int j = 0; j < split.length; j++) {
        if (Integer.parseInt(split[j]) == i) {
          count++;
        }
      }
      writer.write(count + "\n");
    }

    writer.flush();
    writer.close();
    reader.close();
  }
}
