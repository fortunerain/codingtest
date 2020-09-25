package com.exam.test.arraystring;

public class StringZip {
  public static void main(String[] args) {
    String s = "aabbaccc"; // 2a2ba3c

    int zip = zip(s);
    System.out.println(zip);
  }

  public static int zip(String s) {
    int answer = s.length();

    for (int i = 1; i <= s.length() / 2; i++) {
      StringBuilder temp = new StringBuilder();

      for (int j = 0; j < s.length(); j = j + i) {
        String word = "";

        if (j + i >= s.length()) {
          word = s.substring(j);
        } else {
          word = s.substring(j, j + i);
        }

        int count = 1;
        StringBuilder builder = new StringBuilder();

        // 다음 문자열
        for (int k = j + i; k < s.length(); k = k + i) {
          String word2 = "";

          if (k + i >= s.length()) {
            word2 = s.substring(k);
          } else {
            word2 = s.substring(k, k + i);
          }

          if (word.equals(word2)) {
            count++;
            j = k;
          } else {
            break;
          }
        }

        if (count == 1) {
          builder.append(word);
        } else {
          builder.append(count).append(word);
        }

        temp.append(builder.toString());
      }

      answer = Math.min(answer, temp.toString().length());
    }

    return answer;
  }

  public static int zip2(String s) {
    int answer = s.length();

    for(int n=1 ; n<=s.length()/2 ; n++) {
      StringBuilder temp = new StringBuilder();

      for(int i=0 ; i<s.length() ; i = i+n) {
        String word = "";

        if(i+n >= s.length()) word = s.substring(i, s.length());
        else word = s.substring(i, i+n);

        int cnt = 1;
        StringBuilder sb = new StringBuilder();

        for(int j=i+n ; j<s.length() ; j=j+n) {
          String word2 = "";

          if(j+n >= s.length()) {
            word2 = s.substring(j, s.length());
          } else {
            word2 = s.substring(j, j+n);
          }

          if(word.equals(word2)) {
            cnt++;
            i = j;
          } else {
            break;
          }
        }

        if(cnt == 1) sb.append(word);
        else sb.append(cnt).append(word);

        temp.append(sb.toString());
      }

      answer = Math.min(answer, temp.toString().length());
    }

    return answer;
  }
}
