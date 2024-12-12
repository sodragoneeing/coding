package org.study.softeer.level_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GradeAverage {

  /*
   *
   * 문제 출처 : Softeer
   * 문제 이름 : 성적 평균
   *
   * 입력 예제
   * 5 3
   * 10 50 20 70 100
   * 1 3
   * 3 4
   * 1 5
   *
   * 출력 예제
   * 26.67
   * 45.00
   * 50.00
   *
   */

  public static void main(String[] args) throws IOException {

    int N; // 학생 인원수
    int K; // 구간 개수

    String[] inputInfo; // 학생 수, 구간 수 입력 정보
    String[] inputScore;   // 점수 입력 정보
    String[] inputIndexRange;

    int[] stackScore;   // 구간별 점수 합계 정보

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    inputInfo = br.readLine().split(" ");

    N = Integer.parseInt(inputInfo[0]);
    K = Integer.parseInt(inputInfo[1]);

    // 점수 입력 받기
    inputScore = br.readLine().split(" ");

    stackScore = new int[inputScore.length];
    Arrays.fill(stackScore, 0);

    int totalScore = 0;
    for(int i = 0; i < inputScore.length; i++) {
      totalScore += Integer.parseInt(inputScore[i]);
      stackScore[i] = totalScore;
    }

    // 구간 정보 입력 받아서 평균 계산하기
    for(int i = 0; i < K; i++) {
      inputIndexRange = br.readLine().split(" ");

      int startIndex = Integer.parseInt(inputIndexRange[0]);
      int endIndex = Integer.parseInt(inputIndexRange[1]);

      int rangeSumScore = 0;
      if(startIndex == 1) {
        rangeSumScore = stackScore[endIndex - 1];
      }
      else {
        rangeSumScore = stackScore[endIndex - 1] - stackScore[startIndex - 2];
      }

      int studentCount = endIndex - startIndex + 1;
      System.out.printf("%.2f%n",  rangeSumScore / (float) studentCount);
    }

  }
}
