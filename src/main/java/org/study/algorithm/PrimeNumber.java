package org.study.algorithm;

import java.io.IOException;
import java.util.Scanner;

public class PrimeNumber {

  /*
   * 입력
   * 1
   * 출력
   * false
   *
   * 입력
   * 2
   * 출력
   * true
   *
   * 입력
   * 17
   * 출력
   * true
   *
   * 입력
   * 4
   * 출력
   * false
   *
   */

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();

    System.out.println(distinguishPrimeNum(num));
  }

  static private boolean distinguishPrimeNum(int num) {
    if(num <= 1) {
      return false;
    }

    for(int i = 2; i < num; i++) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }
}
