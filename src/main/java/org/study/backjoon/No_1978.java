package org.study.backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1978 {
  static int n;
  static int[] number;

  public static void main(String[] args) throws IOException {
    /*
     *
     * 입력 정보
     *
     * 4
     * 1 3 5 7
     *
     * 결과 정보
     * 3
     *
     */

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

    n = Integer.parseInt(stringTokenizer.nextToken());

    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
    number = new int[n];
    for(int i = 0; i < number.length; i++) {
      number[i] = Integer.parseInt(stringTokenizer.nextToken());
    }

    int count = 0;
    for(int i = 0; i < n; i++) {
      if(distinguishPrimeNum(number[i])) {
        count++;
      }
    }

    System.out.println(count);


  }

  static private boolean distinguishPrimeNum(int num) {
    if(num <= 1) {
      return false;
    }

    for(int i = 2; i < num; i++) {
      if(num % i == 0) {
        return false;
      }
    }

    return true;
  }


}
