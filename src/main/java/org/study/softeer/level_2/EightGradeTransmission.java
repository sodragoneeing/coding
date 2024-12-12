package org.study.softeer.level_2;

import java.util.Scanner;

public class EightGradeTransmission {
  public static void main(String[] args) {

    /*
     *
     * 문제 출처 : Softeer
     * 문제 이름 : 8단 변속기
     *
     * 입력 예제
     * 1 2 3 4 5 6 7 8
     *
     * 출력 예제
     * ascending
     *
     */

    String input;
    String[] arrGear;

    Scanner sc = new Scanner(System.in);
    input = sc.nextLine();
    arrGear = input.split(" ");

    if (chkAsc(arrGear)) {
      System.out.println("ascending");
      return;
    }

    if (chkDesc(arrGear)) {
      System.out.println("descending");
      return;
    }

    System.out.println("mixed");
  }
  static boolean chkAsc(String[] arrGear) {
    for(int i = 0; i < arrGear.length - 1; i++) {
      if(Integer.parseInt(arrGear[i + 1]) - Integer.parseInt(arrGear[i]) != 1) {
        return false;
      }
    }
    return true;
  }

  static boolean chkDesc(String[] arrGear) {
    for(int i = 0; i < arrGear.length - 1; i++) {
      if(Integer.parseInt(arrGear[i]) - Integer.parseInt(arrGear[i + 1]) != 1) {
        return false;
      }
    }
    return true;
  }
}
