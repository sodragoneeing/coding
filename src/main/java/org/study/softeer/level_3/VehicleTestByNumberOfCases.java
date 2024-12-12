package org.study.softeer.level_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class VehicleTestByNumberOfCases {
  /*
   *
   * 문제 출처 : Softeer
   * 문제 이름 : 자동차 테스트
   * 추가 설명 : 문제를 경우의 수로 해결
   *
   * 입력 예제
   * 5 3
   * 5 2 3 1 6
   * 1
   * 3
   * 6
   *
   * 출력 예제
   * 0
   * 4
   * 0
   *
   *********************************
   *
   * 입력 예제
   * 6 8
   * 7 4 3 2 6 1
   * 1
   * 2
   * 3
   * 4
   * 5
   * 6
   * 7
   * 1000000000
   *
   * 출력 예제
   * 0
   * 4
   * 6
   * 6
   * 0
   * 4
   * 0
   * 0
   *
   */

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String[] firstLine = br.readLine().split(" ");
    int n = Integer.parseInt(firstLine[0]);
    int q = Integer.parseInt(firstLine[1]);

    String[] efficiencyInput = br.readLine().split(" ");
    int[] efficiencies = new int[n];
    for (int i = 0; i < n; i++) {
      efficiencies[i] = Integer.parseInt(efficiencyInput[i]);
    }
    Arrays.sort(efficiencies);

    while (q-- > 0) {
      int mi = Integer.parseInt(br.readLine());
      sb.append(countMedianCases(efficiencies, mi)).append("\n");
    }

    System.out.print(sb);
  }

  private static long countMedianCases(int[] arr, int mi) {
    int n = arr.length;

    // `mi`가 중앙값으로 가능한 위치
    int midIdx = Arrays.binarySearch(arr, mi);
    if (midIdx < 0) {
      return 0; // `mi`가 배열에 없으면 경우의 수는 0
    }

    // 왼쪽 (mi보다 작은 값 개수)
    long leftCount = midIdx;
    // 오른쪽 (mi보다 큰 값 개수)
    long rightCount = arr.length - midIdx - 1;

    // 가능한 조합 계산
    return leftCount * rightCount;
  }
}
